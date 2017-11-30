package communityWardrobe.tiacloud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import communityWardrobe.tiacloud.model.entity.FileEntity;
import communityWardrobe.tiacloud.repository.FileRepository;
import communityWardrobe.tiacloud.service.FileService;

@Service
public class FileServiceImpl implements FileService {

	@Autowired
	private FileRepository fileRepository;
	
	@Override
	public boolean isFolderExists(String folderName) {
		
		boolean folderExists =false;
		
		if(fileRepository.findByFolderName(folderName)!=null && fileRepository.findByFolderName(folderName).size()>=1) {
			folderExists =true;
		}
		return folderExists;
	}
	@Override
	public boolean isBucketExists(String bucketName) {
		
		boolean bucketExists =false;
		
		if(fileRepository.findByBucketName(bucketName)!=null && fileRepository.findByBucketName(bucketName).size()>=1) {
			bucketExists =true;
		}
		return bucketExists;
	}

	@Override
	public boolean isFileExists(String filekey) {
		boolean fileExists =false;
		if(fileRepository.findByFileKey(filekey)!=null && fileRepository.findByFileKey(filekey).size()>=1) {
			fileExists =true;
		}
		return fileExists;
	}

	@Override
	public int insertFile(FileEntity file) {
		// TODO Auto-generated method stub
		int retVal =0;
		fileRepository.save(file);
		retVal =1;
		return retVal;
	}

	@Override
	public boolean updateFile(FileEntity file) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public String getFileKeyFromLoc(String bucketName, String folderName,  Double locX, Double locY) {
		
		
		return fileRepository.findFileKeyByLoc(bucketName, folderName, locX, locY);
//		return null;
	}

}
