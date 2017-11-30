package communityWardrobe.tiacloud.model.vo;

import org.springframework.web.multipart.MultipartFile;

public class FileInfo {
	
	private String fileKey;
	private String fileName;
	private boolean fileOverRide;
	private MultipartFile file;
	private String bucketName;
	private String folderName;
	private Double locX;
	private Double locY;

	public FileInfo() {
		super();
	}
	public FileInfo(String fileKey, String fileName, boolean fileOverRide, MultipartFile file) {
		super();
		this.fileKey = fileKey;
		this.fileName = fileName;
		this.fileOverRide = fileOverRide;
		this.file = file;
	}
	
	public FileInfo(String fileKey, String fileName, boolean fileOverRide, MultipartFile file, String bucketName,
			String folderName) {
		super();
		this.fileKey = fileKey;
		this.fileName = fileName;
		this.fileOverRide = fileOverRide;
		this.file = file;
		this.bucketName = bucketName;
		this.folderName = folderName;
	}
	

	public FileInfo(String fileKey, String fileName, boolean fileOverRide, MultipartFile file, String bucketName,
			String folderName, Double locX, Double locY) {
		super();
		this.fileKey = fileKey;
		this.fileName = fileName;
		this.fileOverRide = fileOverRide;
		this.file = file;
		this.bucketName = bucketName;
		this.folderName = folderName;
		this.locX = locX;
		this.locY = locY;
	}
	public String getFileKey() {
		return fileKey;
	}
	public void setFileKey(String fileKey) {
		this.fileKey = fileKey;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public boolean isFileOverRide() {
		return fileOverRide;
	}
	public void setFileOverRide(boolean fileOverRide) {
		this.fileOverRide = fileOverRide;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public String getBucketName() {
		return bucketName;
	}
	public void setBucketName(String bucketName) {
		this.bucketName = bucketName;
	}
	public String getFolderName() {
		return folderName;
	}
	public void setFolderName(String folderName) {
		this.folderName = folderName;
	}
	public Double getLocX() {
		return locX;
	}
	public void setLocX(Double locX) {
		this.locX = locX;
	}
	public Double getLocY() {
		return locY;
	}
	public void setLocY(Double locY) {
		this.locY = locY;
	}

	
}
