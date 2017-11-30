package communityWardrobe.Controller.model;

public class OrderDetailDTO {
  private InventoryDTO inventoryDTO;
  private UserAddressDTO userAddressDTO;

  public OrderDetailDTO() {
  }

  public InventoryDTO getInventoryDTO() {
    return inventoryDTO;
  }

  public void setInventoryDTO(InventoryDTO inventoryDTO) {
    this.inventoryDTO = inventoryDTO;
  }

  public UserAddressDTO getUserAddressDTO() {
    return userAddressDTO;
  }

  public void setUserAddressDTO(UserAddressDTO userAddressDTO) {
    this.userAddressDTO = userAddressDTO;
  }
}
