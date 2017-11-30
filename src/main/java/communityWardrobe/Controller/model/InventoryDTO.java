package communityWardrobe.Controller.model;

import java.util.List;

public class InventoryDTO {

	private String category;
	
	private List<InventoryDetailsDTO> details;

	public InventoryDTO() {
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public List<InventoryDetailsDTO> getDetails() {
		return details;
	}

	public void setDetails(List<InventoryDetailsDTO> details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "InventoryDTO [category=" + category + ", details=" + details + "]";
	}

}
