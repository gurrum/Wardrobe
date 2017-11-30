package communityWardrobe.tiacloud.service;

import communityWardrobe.tiacloud.model.entity.FileEntity;

public interface FileService {
	
	int insertFile(FileEntity file);
	boolean updateFile(FileEntity file);
	boolean isFolderExists(String folderName);
	boolean isFileExists(String fileName);
	boolean isBucketExists(String bucketName);
	String getFileKeyFromLoc(String bucketName, String folderName, Double locX, Double locY);

}
