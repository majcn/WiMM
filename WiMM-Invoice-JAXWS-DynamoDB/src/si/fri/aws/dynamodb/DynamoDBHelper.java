package si.fri.aws.dynamodb;

import javax.naming.ConfigurationException;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.PropertiesCredentials;
import com.amazonaws.services.dynamodb.AmazonDynamoDB;
import com.amazonaws.services.dynamodb.AmazonDynamoDBClient;

public class DynamoDBHelper {
    		
    public static AmazonDynamoDB createClient(Boolean enableErrorRetry, String endpointUrl) throws ConfigurationException{
    	
    	AWSCredentials awsCredentials = getAWSCredentials();
		ClientConfiguration cc=new ClientConfiguration();
		
		if(!enableErrorRetry)
			cc.setMaxErrorRetry(0);
		
		//for debugging with fiddler
		//cc.setProtocol(Protocol.HTTP);
		//cc.setProxyHost("localhost");
		//cc.setProxyPort(8888);
		
		AmazonDynamoDB client= new AmazonDynamoDBClient(awsCredentials, cc);
				
		//Set dynamo endpoint to Ireland
		client.setEndpoint(endpointUrl);
		
		return client;
		
    }
    
    private static AWSCredentials getAWSCredentials() throws ConfigurationException{
    	AWSCredentials credentials;
		try {
			credentials = new PropertiesCredentials(DynamoDBHelper.class.getClassLoader().getResourceAsStream("AwsCredentials.properties"));
		} catch (Exception e) {
			ConfigurationException ce=new ConfigurationException("Error loading AWS credentials");
			ce.initCause(e);
			throw ce;
		}
    	
    	return credentials;
    }
           
}
