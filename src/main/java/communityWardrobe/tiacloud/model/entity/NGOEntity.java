package communityWardrobe.tiacloud.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "NGO")
public class NGOEntity {


  @Column(name = "ID")
  String cert80GNo;

  @Column(name = "CERT_80G")
  boolean cert80G;

  @Id
  @Column(name = "NAME")
  String name;

  @Column(name = "EMAIL")
  String email;

  @Column(name = "PHONE")
  String phone;

  @Column(name = "ADDRESS")
  String address;

  @Column(name = "NO_OF_YEAR_REG")
  int noOfYearOFReg;

  @Column(name = "DOCS_UPLOADED")
  boolean docUploaded;

  @Column(name = "PPT_UPLOADED")
  boolean pptUploaded;

  public String getCert80GNo() {
    return cert80GNo;
  }

  public void setCert80GNo(String cert80GNo) {
    this.cert80GNo = cert80GNo;
  }

  public boolean isCert80G() {
    return cert80G;
  }

  public void setCert80G(boolean cert80G) {
    this.cert80G = cert80G;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public int getNoOfYearOFReg() {
    return noOfYearOFReg;
  }

  public void setNoOfYearOFReg(int noOfYearOFReg) {
    this.noOfYearOFReg = noOfYearOFReg;
  }

  public boolean isDocUploaded() {
    return docUploaded;
  }

  public void setDocUploaded(boolean docUploaded) {
    this.docUploaded = docUploaded;
  }

  public boolean isPptUploaded() {
    return pptUploaded;
  }

  public void setPptUploaded(boolean pptUploaded) {
    this.pptUploaded = pptUploaded;
  }
}
