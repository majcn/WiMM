package si.fri.wimm;

import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.mail.search.RecipientStringTerm;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import si.fri.wimm.util.ResizeHelper;
import si.fri.wimm.util.S3Helper;

import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.GetTopicAttributesRequest;
import com.amazonaws.services.sns.model.GetTopicAttributesResult;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClient;
import com.amazonaws.services.sqs.model.DeleteMessageRequest;
import com.amazonaws.services.sqs.model.GetQueueAttributesRequest;
import com.amazonaws.services.sqs.model.GetQueueAttributesResult;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;

public class SQSWorker{
	
	private AmazonSQS sqsClient;
	private AmazonSNS snsClient;
	
	private String inputQueueUrl;
	private String logTopicArn;
	
	private String machineName;
	
	private static final String SQS_ENDPOINT_URL="https://sqs.eu-west-1.amazonaws.com";
	private static final String SNS_ENDPOINT_URL="https://sns.eu-west-1.amazonaws.com";
	private static final List<String> JSON_KEYS = Arrays.asList("operation", "s3Endpoint", "bucketName", "inputFilePath", "outputFolderPath", "thumbnailSize");
	
	private AWSCredentials credentials;
		
	public SQSWorker(String accessKey, String secretKey, String inputQueueUrl, String logTopicArn){
		
		//worker tries to read current machine name for including it in log messages
		try {
			this.machineName=InetAddress.getLocalHost().getHostName();
		} catch (UnknownHostException e) {
			this.machineName="unknown host";
		}
		
		//create the credentials for using AWS
		this.credentials=new BasicAWSCredentials(accessKey, secretKey);
				
		//create the SQS client for input messages
		this.sqsClient=new AmazonSQSClient(credentials);
		this.sqsClient.setEndpoint(SQS_ENDPOINT_URL);
		
		//create the SNS client for log messages
		this.snsClient=new AmazonSNSClient(credentials);
		this.snsClient.setEndpoint(SNS_ENDPOINT_URL);
		
		//input queue parameter validation
		validateQueueUrl("input queue", inputQueueUrl);
		this.inputQueueUrl=inputQueueUrl;
		
		//log topic parameter validation
		validateTopicArn("log topic", logTopicArn);
		this.logTopicArn=logTopicArn;
		
		//say hello to the outside world (SNS topic)
		this.logMessage("I am alive and ready to work!");
		
	}
	
	private void validateQueueUrl(String queueName, String queueUrl){
		try{
			GetQueueAttributesResult queueAttrs=this.sqsClient.getQueueAttributes(new GetQueueAttributesRequest(queueUrl).withAttributeNames("All"));
			
			String numOfMessages=queueAttrs.getAttributes().get("ApproximateNumberOfMessages");
			
			System.out.println("Successfully connected to "+queueName+". Approximate number of messages in queue: "+numOfMessages);
		}
		catch(AmazonClientException e)
		{
			System.err.println("Error connecting to "+queueName+" with url "+queueUrl);
			e.printStackTrace();
			throw e;
		}
	}
	
	private void validateTopicArn(String topicName, String topicArn){
		try{
			GetTopicAttributesResult result=this.snsClient.getTopicAttributes(new GetTopicAttributesRequest(topicArn));
									
			System.out.println("Successfully connected to "+topicName+" with topicArn: "+topicArn+"." );
		}
		catch(AmazonClientException e)
		{
			System.err.println("Error connecting to "+topicName+" with topicArn "+topicArn);
			e.printStackTrace();
			throw e;
		}
	}
	
	
	 public void run() {
	        try {
	        	System.out.println("Getting input messages in infinite loop from queue: "+inputQueueUrl);
	        	while ( true ) {
	        		//call a blocking method for retrieving the message
	            	Message m=getInputMessage();
	            	if(m != null)
	            		doWork(m);
	            }
	        }
	        catch ( Exception ie ) { 
	            ie.printStackTrace();
	            System.err.println("Worker ending!");
	        }
	}
	 
	private Message getInputMessage(){
		ReceiveMessageRequest receiveMessageRequest = new ReceiveMessageRequest(inputQueueUrl);
		//use long polling (for example 10s)
		receiveMessageRequest.setWaitTimeSeconds(10);
		List<Message> messages = sqsClient.receiveMessage(receiveMessageRequest).getMessages();

		Message m = null;
		if(!messages.isEmpty()) {
			m = messages.get(0);
		}
		return m;
	}
	
	private void logMessage(String message)
	{
		//add machineName to message that we can distinct messages from different instances
		String formattedMessage=String.format("%s: %s", this.machineName, message);
	
		snsClient.publish(new PublishRequest(logTopicArn, "Log", formattedMessage));
		
		System.out.println(String.format("Log message: %s", message));

	}
	 
	private void doWork(Message m) throws IOException{
		String messageBody=m.getBody();
		
		//parse message from JSON object with method, which is implemented for you
		Map<String,Object> jsonMessage=parseMessageBodyJSON(messageBody);
		
		//perform some validation
		if(jsonMessage==null || !jsonMessage.keySet().containsAll(JSON_KEYS)) {
			this.logMessage("Message body JSON parsing failed. Message body: "+messageBody+"\r\n, Deleting message.");
		} else {
			String s3Endpoint = (String)jsonMessage.get("s3Endpoint");
			String bucketName = (String)jsonMessage.get("bucketName");
			int thumbnailSize = (Integer)jsonMessage.get("thumbnailSize");
			String inputFilePath = (String)jsonMessage.get("inputFilePath");
			String outputFolderPath = (String)jsonMessage.get("outputFolderPath");
			AmazonS3 s3 = S3Helper.createClient(credentials, s3Endpoint);
			InputStream file = S3Helper.downloadFile(s3, bucketName, inputFilePath);
			BufferedImage i = ResizeHelper.resize(ImageIO.read(file), thumbnailSize, thumbnailSize, RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR, true);		
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			ImageIO.write(i, "jpg", os);
			os.flush();
			S3Helper.uploadImageFile(s3, bucketName, outputFolderPath+"/"+inputFilePath, new ByteArrayInputStream(os.toByteArray()));
			this.logMessage("Created thumb at: "+outputFolderPath+"/"+inputFilePath);
		}
		
		sqsClient.deleteMessage(new DeleteMessageRequest(inputQueueUrl, m.getReceiptHandle()));
		
	}



	
	private Map<String,Object> parseMessageBodyJSON(String messageBody)
	{
		ObjectMapper mapper = new ObjectMapper();
		try {
			@SuppressWarnings("unchecked")
			Map<String,Object> jsonObject = mapper.readValue(messageBody, Map.class);
			return jsonObject;
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
}
