package communityWardrobe.tiacloud.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "INVENTORY")
public class InventoryEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "inventory_seq")
   	@SequenceGenerator(name = "inventory_seq", sequenceName = "INVENTORY_SEQ", initialValue = 1000000 ,allocationSize = 1)
	@Column(name = "ID")
	private Integer inventoryId;
	
	@Column(name = "CATEGORY")
	private String category;
	
	@Column(name = "TYPE")
	private String type;
	
	@Column(name = "SIZE")
	private String size;
	
	@Column(name = "QUANTITY")
	private Integer quantity;

	public Integer getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(Integer inventoryId) {
		this.inventoryId = inventoryId;
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

	@Override
	public String toString() {
		return "Inventory [inventoryId=" + inventoryId + ", category=" + category + ", type=" + type + ", size=" + size
		        + ", quantity=" + quantity + "]";
	}
}