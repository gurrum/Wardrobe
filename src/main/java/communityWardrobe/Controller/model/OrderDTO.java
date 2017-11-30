package communityWardrobe.Controller.model;

import java.util.List;

public class OrderDTO {
  private List<InventoryOrderDetailsDTO> inventoryOrderDetailsDTOList;
  private UserAddressDTO userAddressDTO;

  public List<InventoryOrderDetailsDTO> getInventoryOrderDetailsDTOList() {
    return inventoryOrderDetailsDTOList;
  }

  public void setInventoryOrderDetailsDTOList(List<InventoryOrderDetailsDTO> inventoryOrderDetailsDTOList) {
    this.inventoryOrderDetailsDTOList = inventoryOrderDetailsDTOList;
  }

  public UserAddressDTO getUserAddressDTO() {
    return userAddressDTO;
  }

  public void setUserAddressDTO(UserAddressDTO userAddressDTO) {
    this.userAddressDTO = userAddressDTO;
  }
}
