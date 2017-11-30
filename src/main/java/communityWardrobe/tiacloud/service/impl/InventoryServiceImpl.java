package communityWardrobe.tiacloud.service.impl;

import communityWardrobe.Controller.model.InventoryDTO;
import communityWardrobe.Controller.model.InventoryDetailsDTO;
import communityWardrobe.Controller.model.InventoryResponseDTO;
import communityWardrobe.tiacloud.model.entity.InventoryEntity;
import communityWardrobe.tiacloud.repository.InventoryRepository;
import communityWardrobe.tiacloud.service.InventoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class InventoryServiceImpl implements InventoryService{

	@Autowired
	private InventoryRepository inventoryRepository;
	
	@Override
	public InventoryResponseDTO getInventoryResponse() {
		InventoryResponseDTO response = null;
		List<InventoryDTO> listOfInventory = new ArrayList<>();
		List<String> categories = inventoryRepository.findDistinctCategory();
		
		
		if(categories== null|| categories.isEmpty()){
			return null;
		}
		
		for (String category : categories) {
			listOfInventory.add(getInventoryDTO(category));
		}
		if (!listOfInventory.isEmpty()) {
			response = new InventoryResponseDTO();
			response.setInventory(listOfInventory);
		}
		return response;

	}

	private InventoryDTO getInventoryDTO(String category) {
		InventoryDTO inventory = new InventoryDTO();
		inventory.setCategory(category);
		inventory.setDetails(getInventoryDetails(category));
		return inventory;
	}

	private List<InventoryDetailsDTO> getInventoryDetails(String category) {
		List<InventoryDetailsDTO> inventories = new ArrayList<>();
		List<InventoryEntity> inventoryEntities = inventoryRepository.findByCategory(category);
		for (InventoryEntity inventoryEntity : inventoryEntities) {
			inventories.add(new InventoryDetailsDTO(inventoryEntity.getType(),inventoryEntity.getSize(), inventoryEntity.getQuantity()));
		}
		return (!inventories.isEmpty()) ? inventories : null;
	}

	@Override
	public void postInventories(List<InventoryDTO> inventories){

		for(InventoryDTO inventory: inventories){
			for(InventoryDetailsDTO inventoryDetail: inventory.getDetails()){
				InventoryEntity entity = new InventoryEntity();
				entity.setCategory(inventory.getCategory());
				entity.setQuantity(inventoryDetail.getQuantity());
				entity.setSize(inventoryDetail.getSize());
				entity.setType(inventoryDetail.getType());
				inventoryRepository.save(entity);
			}

		}

		return;
	}
}