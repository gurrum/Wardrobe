package communityWardrobe.tiacloud.service;

import communityWardrobe.Controller.model.InventoryDTO;
import communityWardrobe.Controller.model.InventoryResponseDTO;

import java.util.List;

public interface InventoryService {

	InventoryResponseDTO getInventoryResponse();

	void postInventories(List<InventoryDTO> inventoryDTO);

}
