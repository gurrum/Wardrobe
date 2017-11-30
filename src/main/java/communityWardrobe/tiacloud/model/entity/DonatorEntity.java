package communityWardrobe.tiacloud.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "DONATOR")
public class DonatorEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "donator_seq")
   	@SequenceGenerator(name = "donator_seq", sequenceName = "DONATOR_SEQ", initialValue = 1000000 ,allocationSize = 1)
	@Column(name = "ID")
	private Integer donatorId;
	
	@Column(name = "DONATOR_NAME")
	private String donatorName;
	
	@Column(name = "DONATOR_ADDRESS")
	private String donatorAddress;

	public Integer getDonatorId() {
		return donatorId;
	}

	public void setDonatorId(Integer donatorId) {
		this.donatorId = donatorId;
	}

	public String getDonatorName() {
		return donatorName;
	}

	public void setDonatorName(String donatorName) {
		this.donatorName = donatorName;
	}

	public String getDonatorAddress() {
		return donatorAddress;
	}

	public void setDonatorAddress(String donatorAddress) {
		this.donatorAddress = donatorAddress;
	}
}