package communityWardrobe.Controller.model;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
		"item",
		"quantity",
		"size"
})
public class InventoryDetailsCopyDTO {

	@JsonProperty("item")
	private String type;

	@JsonProperty("size")
	private String size;

	@JsonProperty("quantity")
	private Integer quantity;

	public InventoryDetailsCopyDTO() {
	}

	public InventoryDetailsCopyDTO(String type, String size, Integer quantity) {
		this.type = type;
		this.size = size;
		this.quantity = quantity;
	}

	@JsonProperty("item")
	public String getType() {
		return type;
	}

	@JsonProperty("item")
	public void setType(String type) {
		this.type = type;
	}

	@JsonProperty("size")
	public String getSize() {
		return size;
	}

	@JsonProperty("size")
	public void setSize(String size) {
		this.size = size;
	}

	@JsonProperty("quantity")
	public Integer getQuantity() {
		return quantity;
	}

	@JsonProperty("quantity")
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "InventoryDetailsDTO [type=" + type + ", size=" + size + ", quantity=" + quantity + "]";
	}
	
}
