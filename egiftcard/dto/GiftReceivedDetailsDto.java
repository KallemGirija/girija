package com.cg.egiftcard.dto;

import java.util.Date;

public class GiftReceivedDetailsDto {

	private Long giftReceivedId;

	private String giftCardReceivedDate;

	private Long userId;

	private String receiverAddress;

	private Long userGiftId;

	public Long getGiftReceivedId() {
		return giftReceivedId;
	}

	public void setGiftReceivedId(Long giftReceivedId) {
		this.giftReceivedId = giftReceivedId;
	}

	public String getGiftCardReceivedDate() {
		return giftCardReceivedDate;
	}

	public void setGiftCardReceivedDate(String giftCardReceivedDate) {
		this.giftCardReceivedDate = giftCardReceivedDate;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getReceiverAddress() {
		return receiverAddress;
	}

	public void setReceiverAddress(String receiverAddress) {
		this.receiverAddress = receiverAddress;
	}

	public Long getUserGiftId() {
		return userGiftId;
	}

	public void setUserGiftId(Long userGiftId) {
		this.userGiftId = userGiftId;
	}

	@Override
	public String toString() {
		return "GiftReceivedDetailsDto [giftReceivedId=" + giftReceivedId + ", giftCardReceivedDate="
				+ giftCardReceivedDate + ", userId=" + userId + ", receiverAddress=" + receiverAddress + ", userGiftId="
				+ userGiftId + "]";
	}

}
