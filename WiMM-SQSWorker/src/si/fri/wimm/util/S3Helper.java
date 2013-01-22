package si.fri.wimm.util;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.S3Object;

public class S3Helper {
	
	public static AmazonS3 createClient(AWSCredentials c, String endpointUrl){
		AmazonS3 s3 = new AmazonS3Client(c);
		s3.setEndpoint(endpointUrl);
		return s3;
	}
	
	public static InputStream downloadFile(AmazonS3 s3, String bucketName, String filePath){

		S3Object obj=s3.getObject(bucketName, filePath);
		return obj.getObjectContent();
	}
	
	public static void uploadImageFile(AmazonS3 s3, String bucketName, String filePath, ByteArrayInputStream stream){
		ObjectMetadata metadata=new ObjectMetadata();
		metadata.setContentType("image/jpeg");
		metadata.setContentLength(stream.available());
		s3.putObject(bucketName, filePath, stream, metadata);
	}
}
