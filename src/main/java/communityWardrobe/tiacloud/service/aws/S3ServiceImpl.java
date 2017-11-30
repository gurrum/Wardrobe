package communityWardrobe.tiacloud.service.aws;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;

import communityWardrobe.tiacloud.exception.ApplicationException;
import communityWardrobe.tiacloud.model.vo.FileData;

@Service
public class S3ServiceImpl implements S3Service  {

	@Autowired
	private AmazonS3 s3Client;
	
	@Override
	public int createFolder(String bucketName, String folderName) throws ApplicationException {
		
		int result =1;
		ObjectMetadata metadata = new ObjectMetadata();
		metadata.setContentLength(0);
		InputStream emptyContent = new ByteArrayInputStream(new byte[0]);
		PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName,
					folderName, emptyContent, metadata);
		s3Client.putObject(putObjectRequest);
		result =0;
		return result;
	}

	@Override
	public void putObject(String bucketName, String fileLoc, MultipartFile file) throws IOException, ApplicationException {
		
		ObjectMetadata objectMetadata = new ObjectMetadata();
	    objectMetadata.setContentType(file.getContentType());		
		s3Client.putObject(new PutObjectRequest(bucketName, fileLoc, file.getInputStream(), objectMetadata)
                .withCannedAcl(CannedAccessControlList.PublicRead));
		
	}

	@Override
	public List<FileData> getObjectList(String bucketName, String folderName) {
		
		//retrieve from DB
		
		return null;
	}

	@Override
	public byte[] getObject(String bucketName, String filePath) throws IOException, ApplicationException {
		
		S3Object o = s3Client.getObject(bucketName, filePath);
	    S3ObjectInputStream s3is = o.getObjectContent();
		byte[] bytes = null;
		bytes = IOUtils.toByteArray(s3is);
		return bytes;
	}
	
	@Override
	 public Bucket createBucket(String bucketName) {
	        Bucket bucket = null;
	        if (s3Client.doesBucketExist(bucketName)) {
	            System.out.format("Bucket %s already exists.\n", bucketName);
	            bucket = getBucket(bucketName);
	        } else {
	            try {
	            	bucket = s3Client.createBucket(bucketName);
	            } catch (AmazonS3Exception e) {
	                System.err.println(e.getErrorMessage());
	            }
	        }
	        return bucket;
	  }
	 
	 public Bucket getBucket(String bucketName) {
			
	        Bucket bucket = null;
	        List<Bucket> buckets = s3Client.listBuckets();
	        for (Bucket b : buckets) {
	            if (b.getName().equals(bucketName)) {
	            	bucket = b;
	            }
	        }
	        return bucket;
	  }
}
