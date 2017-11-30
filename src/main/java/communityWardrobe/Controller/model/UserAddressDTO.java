package communityWardrobe.Controller.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "address",
    "name"
})
public class UserAddressDTO {
  @JsonProperty("address")
  private String address;
  @JsonProperty("name")
  private String userName;


  public UserAddressDTO() {
  }

  @JsonProperty("address")
  public String getAddress() {
    return address;
  }

  @JsonProperty("address")
  public void setAddress(String address) {
    this.address = address;
  }

  @JsonProperty("name")
  public String getUserName() {
    return userName;
  }

  @JsonProperty("name")
  public void setUserName(String userName) {
    this.userName = userName;
  }
}
