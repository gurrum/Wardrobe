package communityWardrobe.tiacloud.service.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import communityWardrobe.tiacloud.exception.ApplicationException;
import communityWardrobe.tiacloud.model.entity.FileEntity;
import communityWardrobe.tiacloud.model.vo.FileData;
import communityWardrobe.tiacloud.model.vo.FileInfo;
import communityWardrobe.tiacloud.model.vo.FileLoc;
import communityWardrobe.tiacloud.service.FileService;
import communityWardrobe.tiacloud.service.PlcService;
import communityWardrobe.tiacloud.service.aws.S3Service;

@Service
public class PlcServiceImpl implements PlcService{

	@Autowired
	private S3Service s3Service;
	@Autowired
	private FileService fileService;
	
	@Override
	public boolean putFile(FileInfo fileInfo) throws ApplicationException, IOException {
		
		boolean retVal = false;
		boolean isBucketExist = fileService.isFolderExists(fileInfo.getBucketName());
		boolean isFolderExists = fileService.isFolderExists(fileInfo.getFolderName());
		boolean isFileExists = fileService.isFileExists(fileInfo.getFileKey());
		String fileLoc = fileInfo.getFolderName()+"/"+fileInfo.getFileKey();
		if(!isBucketExist) {
			//create bucket
			s3Service.createBucket(fileInfo.getBucketName());
		}
		
		if(!isFolderExists) {
			s3Service.createFolder(fileInfo.getBucketName(), fileInfo.getFolderName());
		}
		try {
			if(isFileExists) {
				if(fileInfo.isFileOverRide()) {
					s3Service.putObject(fileInfo.getBucketName(), fileLoc, fileInfo.getFile());
					//update the fileInfo
					FileEntity file = new FileEntity(fileInfo.getFileKey(),fileInfo.getBucketName(),fileInfo.getFolderName(),fileInfo.getLocX(),fileInfo.getLocY());
					fileService.insertFile(file);
					retVal =true;
				}
			}else {
				s3Service.putObject(fileInfo.getBucketName(), fileLoc, fileInfo.getFile());
				FileEntity file = new FileEntity(fileInfo.getFileKey(),fileInfo.getBucketName(),fileInfo.getFolderName(),fileInfo.getLocX(),fileInfo.getLocY());
				fileService.insertFile(file);
				retVal =true;
			}
		} catch (Exception e) {
			throw new IOException();
		}
			
		return retVal;
	}

	@Override
	public List<FileData> getFileList(String bucketName, String folderName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public byte[] getFile(String bucketName,String folderName, String fileKey) throws IOException, ApplicationException {
		// TODO Auto-generated method stub
		String filePath = folderName+"/"+fileKey;
		byte[] fileData = s3Service.getObject(bucketName, filePath);
		return fileData;
	}

	@Override
	public String getLocFileKey(String bucketName, String folderName, Double locX, Double locY) {
		// TODO Auto-generated method stub
		return fileService.getFileKeyFromLoc(bucketName, folderName, locX, locY);
	}

}
