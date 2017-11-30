package communityWardrobe.tiacloud.model.vo;

public class FileData {
	
	private String fileKey;
	private FileLoc fileLoc;
	
	public FileData() {
		super();
	}
	public FileData(String fileKey, FileLoc fileLoc) {
		super();
		this.fileKey = fileKey;
		this.fileLoc = fileLoc;
	}
	public String getFileKey() {
		return fileKey;
	}
	public void setFileKey(String fileKey) {
		this.fileKey = fileKey;
	}
	public FileLoc getFileLoc() {
		return fileLoc;
	}
	public void setFileLoc(FileLoc fileLoc) {
		this.fileLoc = fileLoc;
	}
	

}
