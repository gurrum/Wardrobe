package communityWardrobe.Controller.model;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "category",
    "details"
})
public class InventoryOrderDetailsDTO {
	private String category;

	private InventoryDetailsCopyDTO inventoryDetailsCopyDTO;

	public InventoryOrderDetailsDTO() {
	}


  @JsonProperty("category")
  public String getCategory() {
    return category;
  }


  @JsonProperty("category")
  public void setCategory(String category) {
    this.category = category;
  }


  @JsonProperty("details")
  public InventoryDetailsCopyDTO getInventoryDetailsCopyDTO() {
    return inventoryDetailsCopyDTO;
  }


  @JsonProperty("details")
  public void setInventoryDetailsCopyDTO(InventoryDetailsCopyDTO inventoryDetailsCopyDTO) {
    this.inventoryDetailsCopyDTO = inventoryDetailsCopyDTO;
  }
}
