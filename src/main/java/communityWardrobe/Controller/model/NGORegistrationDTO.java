package communityWardrobe.Controller.model;


import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "cert80G",
    "cert80GNo",
    "name",
    "email",
    "phone",
    "address",
    "noYearsOfReg",
    "docUploaded",
    "pptUploaded"
})
public class NGORegistrationDTO {

  @JsonProperty("cert80G")
  private Boolean cert80G;
  @JsonProperty("cert80GNo")
  private String cert80GNo;
  @JsonProperty("name")
  private String name;
  @JsonProperty("email")
  private String email;
  @JsonProperty("phone")
  private String phone;
  @JsonProperty("address")
  private String address;
  @JsonProperty("noYearsOfReg")
  private Integer noYearsOfReg;
  @JsonProperty("docUploaded")
  private Boolean docUploaded;
  @JsonProperty("pptUploaded")
  private Boolean pptUploaded;
  @JsonIgnore
  private Map<String, Object> additionalProperties = new HashMap<String, Object>();

  public NGORegistrationDTO() {
  }

  @JsonProperty("cert80G")
  public Boolean getCert80G() {
    return cert80G;
  }

  @JsonProperty("cert80G")
  public void setCert80G(Boolean cert80G) {
    this.cert80G = cert80G;
  }

  @JsonProperty("cert80GNo")
  public String getCert80GNo() {
    return cert80GNo;
  }

  @JsonProperty("cert80GNo")
  public void setCert80GNo(String cert80GNo) {
    this.cert80GNo = cert80GNo;
  }

  @JsonProperty("name")
  public String getName() {
    return name;
  }

  @JsonProperty("name")
  public void setName(String name) {
    this.name = name;
  }

  @JsonProperty("email")
  public String getEmail() {
    return email;
  }

  @JsonProperty("email")
  public void setEmail(String email) {
    this.email = email;
  }

  @JsonProperty("phone")
  public String getPhone() {
    return phone;
  }

  @JsonProperty("phone")
  public void setPhone(String phone) {
    this.phone = phone;
  }

  @JsonProperty("address")
  public String getAddress() {
    return address;
  }

  @JsonProperty("address")
  public void setAddress(String address) {
    this.address = address;
  }

  @JsonProperty("noYearsOfReg")
  public Integer getNoYearsOfReg() {
    return noYearsOfReg;
  }

  @JsonProperty("noYearsOfReg")
  public void setNoYearsOfReg(Integer noYearsOfReg) {
    this.noYearsOfReg = noYearsOfReg;
  }

  @JsonProperty("docUploaded")
  public Boolean getDocUploaded() {
    return docUploaded;
  }

  @JsonProperty("docUploaded")
  public void setDocUploaded(Boolean docUploaded) {
    this.docUploaded = docUploaded;
  }

  @JsonProperty("pptUploaded")
  public Boolean getPptUploaded() {
    return pptUploaded;
  }

  @JsonProperty("pptUploaded")
  public void setPptUploaded(Boolean pptUploaded) {
    this.pptUploaded = pptUploaded;
  }

  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  @JsonAnySetter
  public void setAdditionalProperty(String name, Object value) {
    this.additionalProperties.put(name, value);
  }

  @Override
  public String toString() {
    return "NGORegistrationDTO{" +
        "cert80G=" + cert80G +
        ", cert80GNo='" + cert80GNo + '\'' +
        ", name='" + name + '\'' +
        ", email='" + email + '\'' +
        ", phone=" + phone +
        ", address='" + address + '\'' +
        ", noYearsOfReg=" + noYearsOfReg +
        ", docUploaded=" + docUploaded +
        ", pptUploaded=" + pptUploaded +
        ", additionalProperties=" + additionalProperties +
        '}';
  }
}