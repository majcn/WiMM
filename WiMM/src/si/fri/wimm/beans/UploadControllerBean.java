package si.fri.wimm.beans;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.primefaces.model.UploadedFile;

import si.fri.wimm.entity.Customer;

import com.amazonaws.auth.PropertiesCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.PutObjectRequest;

@Named
@RequestScoped
public class UploadControllerBean {

	 private UploadedFile file;  
	  
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
	            
	            try {
					AmazonS3 s3 = new AmazonS3Client(new PropertiesCredentials(
							Customer.class.getClassLoader().getResourceAsStream("AwsCredentials.properties")));
				
	            String bucketName = "wimmbucket";
	            
	            s3.putObject(new PutObjectRequest(bucketName, file.getFileName(), file.getInputstream(), null));
	            
	            
	            } catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            
	            
	        } 
	        
	    }  
}
