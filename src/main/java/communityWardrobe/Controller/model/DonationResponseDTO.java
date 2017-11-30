package communityWardrobe.Controller.model;

import java.util.List;

public class DonationResponseDTO {

	private List<InventoryDTO> inventory;

	public List<InventoryDTO> getInventory() {
		return inventory;
	}

	public void setInventory(List<InventoryDTO> inventory) {
		this.inventory = inventory;
	}

	@Override
	public String toString() {
		return "InventoryResponseDTO [inventory=" + inventory + "]";
	}
}
