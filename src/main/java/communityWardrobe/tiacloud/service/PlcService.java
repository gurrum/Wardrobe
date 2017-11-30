package communityWardrobe.tiacloud.service;

import java.io.IOException;
import java.util.List;

import communityWardrobe.tiacloud.exception.ApplicationException;
import communityWardrobe.tiacloud.model.vo.FileData;
import communityWardrobe.tiacloud.model.vo.FileInfo;
import communityWardrobe.tiacloud.model.vo.FileLoc;

public interface PlcService {
	
	//S3 service
	boolean putFile(FileInfo dileInfo) throws ApplicationException, IOException;
	List<FileData> getFileList(String bucketName, String folderName);
	byte[] getFile(String bucketName, String folderName, String fileKey) throws IOException, ApplicationException;
	String getLocFileKey(String bucketName, String folderName, Double locX, Double locY);
	

}
