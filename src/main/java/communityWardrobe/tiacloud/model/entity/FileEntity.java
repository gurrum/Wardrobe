package communityWardrobe.tiacloud.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PLC_FILE")
public class FileEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="FILEID")
	private Long fileId;
	@Column(name ="FILEKEY")
	private String fileKey;
	@Column(name ="BUCKETNAME")
	private String bucketName;
	@Column(name ="FOLDERNAME")
	private String folderName;
	@Column(name ="LOCX")
	private Double locX;
	@Column(name ="LOCY")
	private Double locY;
	
	public FileEntity() {
		super();
	}
	public FileEntity(String fileKey, String bucketName, String folderName, Double locX, Double locY) {
		super();
		this.fileKey = fileKey;
		this.bucketName = bucketName;
		this.folderName = folderName;
		this.locX = locX;
		this.locY = locY;
	}
	
	
	public Long getFileId() {
		return fileId;
	}
	public void setFileId(Long fileId) {
		this.fileId = fileId;
	}
	public String getFileKey() {
		return fileKey;
	}
	public void setFileKey(String fileKey) {
		this.fileKey = fileKey;
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
