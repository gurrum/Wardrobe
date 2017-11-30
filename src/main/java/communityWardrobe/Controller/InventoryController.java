package communityWardrobe.Controller;

import communityWardrobe.Controller.model.InventoryDTO;
import communityWardrobe.Controller.model.InventoryResponseDTO;
import communityWardrobe.tiacloud.service.InventoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@EnableAutoConfiguration
public class InventoryController {

	@Autowired
	private InventoryService inventoryService;

	@RequestMapping(value = "/inventories/", method = RequestMethod.GET)
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
