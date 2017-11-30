package communityWardrobe.Controller.model;


import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
public class InventoryOrderDetailsDTO {
	private String category;

	private InventoryDetailsDTO inventoryDetailsDTO;

	public InventoryOrderDetailsDTO() {
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public InventoryDetailsDTO getInventoryDetailsDTO() {
		return inventoryDetailsDTO;
	}

	public void setInventoryDetailsDTO(InventoryDetailsDTO inventoryDetailsDTO) {
		this.inventoryDetailsDTO = inventoryDetailsDTO;
	}

	
}
