package si.fri.wimm.beans;






import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;


import javax.inject.Inject;
import javax.inject.Named;


import org.codehaus.jackson.map.ObjectMapper;
import org.primefaces.model.UploadedFile;

import si.fri.wimm.entity.Customer;
import si.fri.wimm.entity.Invoice;
import si.fri.wimm.entity.Items;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.PropertiesCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.sqs.AmazonSQSClient;
import com.amazonaws.services.sqs.model.SendMessageRequest;

//importi za xml parse
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
@Named
@RequestScoped
public class UploadControllerBean{


	private UploadedFile file;
	 private Invoice addedInvoice;
	 
	 private String imageSrc;
	
	 private List<Items> itemsList;
	 @Inject
	 InvoiceBean invoiceBean;
	  
	    public UploadedFile getFile() {  
	        return file;  
	    }  
	  
	    public void setFile(UploadedFile file) {  
	        this.file = file;  
	    }  
	  
	    public void upload() {  
	        if(file != null) {
	        	
	            FacesMessage msg = new FacesMessage("Datoteka ", file.getFileName() + " je naložena.");  
	            FacesContext.getCurrentInstance().addMessage(null, msg);
	            //parsing xml file
	            if(file.getContentType().endsWith("xml")){

	            	  try {
	            		 Invoice tempInvoice = new Invoice(); 
	            		 
	            		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	            		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	            		Document doc = dBuilder.parse(file.getInputstream());
	            		doc.getDocumentElement().normalize();
	             
	            		System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
	            		//Shrani podatke o shop-u
	            		NodeList shopList = doc.getElementsByTagName("shop");
	            		Node shopNode = shopList.item(0);
	            		Element shopElement = (Element) shopNode;
	            		tempInvoice.setCompany(getTagValue("company",shopElement));
	            		tempInvoice.setAddress(getTagValue("address",shopElement));
	            		tempInvoice.setShopName(getTagValue("shopname",shopElement));
	            		System.out.println(getTagValue("shopname",shopElement));
	            		
	            		NodeList invoiceList = doc.getElementsByTagName("invoice");
	            		Node invoiceNode = invoiceList.item(0);
	            		Element invoiceElement = (Element) invoiceNode;
	            		//dodaj Datum	
	            		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd");
	            	    Date convertedDate = dateFormat.parse(getTagValue("date",invoiceElement)); 
	            		tempInvoice.setDate(convertedDate);
	            		//dodaj status
	            		tempInvoice.setStatus(getTagValue("status",invoiceElement));
	            		//dodaj invoiceNum
	            		tempInvoice.setInvoiceNumber(getTagValue("invoiceNumber",invoiceElement));
	            		//dodaj totalPrice
	            		tempInvoice.setTotalprice(Double.parseDouble(getTagValue("totalprice",invoiceElement)));
	            		
	            		System.out.println(getTagValue("invoiceNumber",invoiceElement));
	            		
	            		NodeList itemList = doc.getElementsByTagName("item");
	            		System.out.println("-----------------------");
	            		itemsList = new ArrayList<Items>();
	            		for (int temp = 0; temp < itemList.getLength(); temp++) {
	            			Items tempItem = new Items();
	            		   Node nNode = itemList.item(temp);
	            		   if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	            			  
	            		      Element eElement = (Element) nNode;
	         
	  	            		  tempItem.setItemname(getTagValue("itemname", eElement));
	  	            		  tempItem.setItemprice(Double.parseDouble(getTagValue("itemprice", eElement)));
	  	            		  tempItem.setItemquantity(Double.parseDouble(getTagValue("itemquantity", eElement)));
	  	            		  tempItem.setItemvalue(Double.parseDouble(getTagValue("itemvalue", eElement)));	  
	  	            		System.out.println("Itemname "+temp+" : "+getTagValue("itemname",eElement));
	  		            	
	             
	            		   }
	            		   itemsList.add(tempItem);
	            		}
	            		tempInvoice.setItems(itemsList);
	            		addedInvoice=tempInvoice;
	            		invoiceBean.addInvoice(addedInvoice);
	            		
	            		imageSrc = "http://blogs-images.forbes.com/ericsavitz/files/2011/05/apple-logo2.jpg";
	            	  } catch (Exception e) {
	            		e.printStackTrace();
	            		
	            	  }
	            	
	              }
	            else {
		            try {
						PropertiesCredentials creds = new PropertiesCredentials(Customer.class.getClassLoader().getResourceAsStream("AwsCredentials.properties"));
						AmazonS3 s3 = new AmazonS3Client(creds);
						String bucketName = "wimmbucket";
						
						AmazonSQSClient sqsClient = new AmazonSQSClient(creds);
						sqsClient.setEndpoint("https://sqs.eu-west-1.amazonaws.com");
						
						Map<String,Object> json = new HashMap<String,Object>();
						json.put("operation", "generateThumbnails");
						json.put("s3Endpoint", "s3-eu-west-1.amazonaws.com");
						json.put("bucketName", bucketName);
						json.put("inputFilePath", file.getFileName());
						json.put("outputFolderPath", "thumbnails");
						json.put("thumbnailSize", 200);
					
						ObjectMapper mapper = new ObjectMapper();
						s3.putObject(new PutObjectRequest(bucketName, file.getFileName(), file.getInputstream(), null));
						sqsClient.sendMessage(new SendMessageRequest("https://sqs.eu-west-1.amazonaws.com/681301621198/WiMM_SQS", mapper.writeValueAsString(json)));
						//for (int i=0;i<50;i++){
						//    sqsClient.sendMessage(new SendMessageRequest("https://sqs.eu-west-1.amazonaws.com/681301621198/WimmStack-InputQueue-17E22VN95EILI", mapper.writeValueAsString(json)));
						//}
						sqsClient.shutdown();
						if(fileExistsInS3(s3, bucketName, "thumbnails/"+file.getFileName())) {
							invoiceBean.setImageName("thumbnails/"+file.getFileName());
						}
		            } catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	            
	            } 
	        } 
	        
	    }
		
		private static boolean fileExistsInS3(AmazonS3 s3, String bucketName, String path)
			throws AmazonClientException, AmazonServiceException {
			    boolean isValidFile = true;
			    try {
			        ObjectMetadata objectMetadata = s3.getObjectMetadata(bucketName, path);
			    } catch (AmazonS3Exception s3e) {
			        if (s3e.getStatusCode() == 404) {
			        // i.e. 404: NoSuchKey - The specified key does not exist
			            isValidFile = false;
			        }
			else {
			            throw s3e;    // rethrow all S3 exceptions other than 404   
			        }
			    }
			return isValidFile;
		}
		
	    private static String getTagValue(String sTag, Element eElement) {
	  		NodeList nlList = eElement.getElementsByTagName(sTag).item(0).getChildNodes();
	  		
	  	        Node nValue = (Node) nlList.item(0);
	  	        try{
	  	        
	  	        	return nValue.getNodeValue();
	  	        }
	  	        catch(Exception e){
	  	        	if(sTag.equals("itemprice")||sTag.equals("itemquantity")||sTag.equals("itemvalue")){
	  	        		return "0.0";
	  	        	}
	  	        	else
	  	        		return "";
	  	        }
	  	  }

		public Invoice getAddedInvoice() {
			return addedInvoice;
		}

		public void setAddedInvoice(Invoice addedInvoice) {
			this.addedInvoice = addedInvoice;
		}

		public List<Items> getItemsList() {
			return itemsList;
		}

		public void setItemsList(List<Items> itemsList) {
			this.itemsList = itemsList;
		}

		public String getImageSrc() {
			return imageSrc;
		}

		public void setImageSrc(String imageSrc) {
			this.imageSrc = imageSrc;
		}
		public void getImage(){
			try{
			
			 imageSrc="https://s3-eu-west-1.amazonaws.com/wimmbucket/"+invoiceBean.getImageName();
			}
			catch(Exception e){
				System.out.println("empty string");
				imageSrc="https://s3-eu-west-1.amazonaws.com/wimmbucket/invoice_printed.gif";
				
			}
			
		}

		
		

		

	
}
