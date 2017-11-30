package communityWardrobe.tiacloud.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "ORDERDETAIL")
public class OrderDetailEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "oId_seq")
  @SequenceGenerator(name = "oId_seq", sequenceName = "OID_SEQ", initialValue = 1000000 ,allocationSize = 1)
  @Column(name = "OID")
  private Integer oId;


  @Column(name = "ORDER_ID")
  private Integer orderId;

  @Column(name = "CATEGORY")
  private String category;

  @Column(name = "TYPE")
  private String type;

  @Column(name = "SIZE")
  String size;

  @Column(name = "QUANTITY")
  Integer quantity;

  public Integer getOrderId() {
    return orderId;
  }

  public void setOrderId(Integer orderId) {
    this.orderId = orderId;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getSize() {
    return size;
  }

  public void setSize(String size) {
    this.size = size;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }
}
