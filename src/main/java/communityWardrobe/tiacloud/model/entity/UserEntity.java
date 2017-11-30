package communityWardrobe.tiacloud.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USERDATA")
public class UserEntity {

  @Id
  @Column(name = "USERNAME")
  String userName;

  @Column(name = "NAME")
  String fullName;

  @Column(name = "EMAIL")
  String email;

  @Column(name = "USER_TYPE")
  String userType;

  @Column(name = "PASSWORD")
  String password;

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getUserType() {
    return userType;
  }

  public void setUserType(String userType) {
    this.userType = userType;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
