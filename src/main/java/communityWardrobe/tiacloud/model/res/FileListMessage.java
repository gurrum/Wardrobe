package communityWardrobe.tiacloud.model.res;

import java.util.List;

import communityWardrobe.tiacloud.model.vo.FileData;

public class FileListMessage extends ResponseMessage {

	private List<FileData> fileDataList;

	public List<FileData> getFileDataList() {
		return fileDataList;
	}

	public void setFileDataList(List<FileData> fileDataList) {
		this.fileDataList = fileDataList;
	}

}
