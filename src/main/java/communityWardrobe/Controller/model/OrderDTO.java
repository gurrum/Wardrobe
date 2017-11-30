package communityWardrobe.Controller.model;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "orderDetails",
    "requestedNGO"
})
public class OrderDTO {

  @JsonProperty("orderDetails")
  private List<InventoryOrderDetailsDTO> inventoryOrderDetailsDTOList;
  @JsonProperty("requestedNGO")
  private UserAddressDTO userAddressDTO;

  @JsonIgnore
  public Map<String, Object> additionalProperties = new HashMap<String, Object>();

  public OrderDTO() {
  }

  @JsonProperty("orderDetails")
  public List<InventoryOrderDetailsDTO> getInventoryOrderDetailsDTOList() {
    return inventoryOrderDetailsDTOList;
  }

  @JsonProperty("orderDetails")
  public void setInventoryOrderDetailsDTOList(List<InventoryOrderDetailsDTO> inventoryOrderDetailsDTOList) {
    this.inventoryOrderDetailsDTOList = inventoryOrderDetailsDTOList;
  }

  @JsonProperty("requestedNGO")
  public UserAddressDTO getUserAddressDTO() {
    return userAddressDTO;
  }

  @JsonProperty("requestedNGO")
  public void setUserAddressDTO(UserAddressDTO userAddressDTO) {
    this.userAddressDTO = userAddressDTO;
  }




  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  @JsonAnySetter
  public void setAdditionalProperty(String name, Object value) {
    this.additionalProperties.put(name, value);
  }
}
