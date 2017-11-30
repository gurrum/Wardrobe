package communityWardrobe.tiacloud.service.aws;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.model.Bucket;

import communityWardrobe.tiacloud.exception.ApplicationException;
import communityWardrobe.tiacloud.model.vo.FileData;

public interface S3Service {

	
	public int createFolder(String bucketName, String folderName) throws ApplicationException;
	
	public void putObject(String bucketName, String fileLoc, MultipartFile file) throws IOException, ApplicationException;
	
	public List<FileData> getObjectList(String bucketName, String folderName);
	
	public byte[] getObject(String bucketName, String filePath) throws IOException, ApplicationException;

	Bucket createBucket(String bucketName);
}
