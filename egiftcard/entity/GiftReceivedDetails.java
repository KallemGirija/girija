package com.cg.egiftcard.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "giftReceivedDetails")
public class GiftReceivedDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long giftReceivedId;

	private Date giftCardReceivedDate;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userId")
	private User user;
	
    @Size(max = 255)
	private String receiverAddress;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userGiftId")
	private UserGiftDetails userGiftDetails;

	public GiftReceivedDetails() {
		super();
	}

	public GiftReceivedDetails(Long giftReceivedId, Date giftCardReceivedDate, User user,
			UserGiftDetails userGiftDetails) {
		super();
		this.giftReceivedId = giftReceivedId;
		this.giftCardReceivedDate = giftCardReceivedDate;
		this.user = user;
		this.userGiftDetails = userGiftDetails;
	}

	public Long getGiftReceivedId() {
		return giftReceivedId;
	}

	public void setGiftReceivedId(Long giftReceivedId) {
		this.giftReceivedId = giftReceivedId;
	}



	public Date getGiftCardReceivedDate() {
		return giftCardReceivedDate;
	}

	public void setGiftCardReceivedDate(Date giftCardReceivedDate) {
		this.giftCardReceivedDate = giftCardReceivedDate;
	}

	public String getReceiverAddress() {
		return receiverAddress;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserGiftDetails getUserGiftDetails() {
		return userGiftDetails;
	}

	public void setUserGiftDetails(UserGiftDetails userGiftDetails) {
		this.userGiftDetails = userGiftDetails;
	}

	public String getReceiveAddress() {
		return receiverAddress;
	}

	public void setReceiverAddress(String receiverAddress) {
		this.receiverAddress = receiverAddress;
	}

	@Override
	public String toString() {
		return "GiftReceivedDetails [giftReceivedId=" + giftReceivedId + ", giftCardReceivedDate="
				+ giftCardReceivedDate + ", user=" + user + ", receiverAddress=" + receiverAddress + ", userGiftDetails="
				+ userGiftDetails + "]";
	}

}
