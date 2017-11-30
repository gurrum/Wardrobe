package communityWardrobe.Controller.model;


import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
public class InventoryDetailsDTO {

	private String type;
	
	private String size;
	
	private Integer quantity;

	public InventoryDetailsDTO() {
	}

	public InventoryDetailsDTO(String type, String size, Integer quantity) {
		this.type = type;
		this.size = size;
		this.quantity = quantity;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "InventoryDetailsDTO [type=" + type + ", size=" + size + ", quantity=" + quantity + "]";
	}
	
}
