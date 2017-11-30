package communityWardrobe.tiacloud.api;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;







import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import communityWardrobe.Controller.model.InventoryDTO;
import communityWardrobe.Controller.model.InventoryResponseDTO;
import communityWardrobe.tiacloud.exception.ApplicationException;
import communityWardrobe.tiacloud.model.res.FileListMessage;
import communityWardrobe.tiacloud.model.res.FileUploadMessage;
import communityWardrobe.tiacloud.model.vo.FileData;
import communityWardrobe.tiacloud.model.vo.FileInfo;
import communityWardrobe.tiacloud.service.InventoryService;
import communityWardrobe.tiacloud.service.PlcService;

@RestController
@RequestMapping("/communityWardrobe/")
public class PLCAPI {
	
	
	@Autowired
	private PlcService plcService;

	@RequestMapping(value ="/uploadFile" , method = RequestMethod.POST)
	public ResponseEntity<FileUploadMessage>  uploadFile( @RequestParam(value="fileKey",required = true) String fileKey,@RequestParam(value="fileName",required = true) String fileName,
			@RequestParam(value="fileOverRide",required = true) boolean fileOverRide,@RequestParam(value="file",required = true) MultipartFile file,@RequestParam(value="bucketName",required = true) String bucketName,@RequestParam(value="folderName",required = true) String folderName,
			@RequestParam(value="locX",required = true) Double locX, @RequestParam(value="locY",required = true) Double locY) 
            		throws ApplicationException, IOException{
		FileInfo fileInfo = new FileInfo(fileKey, fileName, fileOverRide, file, bucketName, folderName, locX, locY);
		plcService.putFile(fileInfo);
		FileUploadMessage fileUploadMessage = new FileUploadMessage();
		fileUploadMessage.setFileKey(fileInfo.getFileKey());
		fileUploadMessage.setMessage("File Uploaded Successfully!!!");
		
		return new ResponseEntity<FileUploadMessage>(fileUploadMessage, HttpStatus.OK);
		
	}
	
	@RequestMapping(value ="/fileList" , method = RequestMethod.GET)
	public ResponseEntity<FileListMessage> getFileList(
		 @RequestParam(value = "bucketName", required = false) String bucketName, @RequestParam(value = "folderName", required = true) String folderName) 
					throws ApplicationException {

		FileListMessage fileListMsg = new FileListMessage();
		List<FileData> fileDataList = plcService.getFileList(bucketName, folderName);
		fileListMsg.setFileDataList(fileDataList);
		fileListMsg.setMessage("Retrieve successful");
			
		return new ResponseEntity<FileListMessage>(fileListMsg, HttpStatus.OK);

	}
	
	@RequestMapping(value = "/downloadFile", method = RequestMethod.GET)
	public ResponseEntity<byte[]> download(@RequestParam(value = "bucketName", required = true) String bucketName,@RequestParam(value = "folderName", required = true) String folderName,
			 @RequestParam(value = "fileKey", required = true) String fileKey)
			throws ApplicationException, IOException, UnsupportedEncodingException {
		
		HttpHeaders httpHeaders = null;
		byte[] bytes = plcService.getFile(bucketName,folderName, fileKey);
		String fileName = null;
		fileName = URLEncoder.encode(fileKey, "UTF-8").replaceAll("\\+", "%20");
		httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		httpHeaders.setContentLength(bytes.length);
		httpHeaders.setContentDispositionFormData("attachment", fileName);
		
		return new ResponseEntity<>(bytes, httpHeaders, HttpStatus.OK);
	}
	
	@RequestMapping(value ="/getLocFileKey" , method = RequestMethod.GET)
	public String  getLocFileKey(){
	 return "abc";   	
		
	}
	@Autowired
	private InventoryService inventoryService;

	@RequestMapping(value = "/inventories", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<InventoryResponseDTO> getInventory() {
		InventoryResponseDTO response = inventoryService.getInventoryResponse();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/inventories", method = RequestMethod.POST)
	public ResponseEntity createInventory(@RequestBody List<InventoryDTO> inventories){

		inventoryService.postInventories(inventories);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(headers, HttpStatus.ACCEPTED);
	}
	
	
	
	
	
}