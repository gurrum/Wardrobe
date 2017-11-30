package communityWardrobe.tiacloud.model.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "DONATION")
public class DonationEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "donation_seq")
   	@SequenceGenerator(name = "donation_seq", sequenceName = "DONATION_SEQ", initialValue = 1000000 ,allocationSize = 1)
	@Column(name = "ID")
	private Integer donationId;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="DONATOR_ID", nullable=false)
	private DonatorEntity donator;
	
	@Column(name = "STATE")
	private String state;
	
	@Column(name = "PICKUP_DATE")
	private Date date;
	
	@Column(name = "PICKUP_TIME_SLOT")
	private String timeSlot;

	@Column(name = "QUANTITY")
	private  String quantity;

	public Integer getDonationId() {
		return donationId;
	}

	public void setDonationId(Integer donationId) {
		this.donationId = donationId;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTimeSlot() {
		return timeSlot;
	}

	public void setTimeSlot(String timeSlot) {
		this.timeSlot = timeSlot;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public DonatorEntity getDonator() {
		return donator;
	}

	public void setDonator(DonatorEntity donator) {
		this.donator = donator;
	}
}