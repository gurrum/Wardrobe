package communityWardrobe.tiacloud.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "ORDER1")
public class OrderEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_seq")
  @SequenceGenerator(name = "order_seq", sequenceName = "ORDER_SEQ", initialValue = 1000000 ,allocationSize = 1)
  @Column(name = "ORDER_ID")
  private Integer orderId;

  @Column(name = "USERNAME")
  private String userName;

  @Column(name = "ADDRESS")
  private String address;

  public Integer getOrderId() {
    return orderId;
  }

  public void setOrderId(Integer orderId) {
    this.orderId = orderId;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }
}
