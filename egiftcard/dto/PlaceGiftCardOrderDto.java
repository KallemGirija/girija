package com.cg.egiftcard.dto;

import com.cg.egiftcard.entity.GiftCard;

public class PlaceGiftCardOrderDto {
	private GiftCard giftCard;
	private Long userId;
	// private Integer giftCardAmount;
	private String giftCardIssueDate;
	private boolean reloadable;
	private String RecipientsName;
	private String RecipientsMobileNumber;
	private String RecipientsEmail;
	private String receiverAddress;
	private String deliveryType;
	private String scheduledelivaryDate;

	public String getReceiverAddress() {
		return receiverAddress;
	}

	public void setReceiverAddress(String receiverAddress) {
		this.receiverAddress = receiverAddress;
	}

	public GiftCard getGiftCard() {
		return giftCard;
	}

	public void setGiftCard(GiftCard giftCard) {
		this.giftCard = giftCard;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getGiftCardIssueDate() {
		return giftCardIssueDate;
	}

	public void setGiftCardIssueDate(String giftCardIssueDate) {
		this.giftCardIssueDate = giftCardIssueDate;
	}

	public boolean isReloadable() {
		return reloadable;
	}

	public void setReloadable(boolean reloadable) {
		this.reloadable = reloadable;
	}

	public String getRecipientsName() {
		return RecipientsName;
	}

	public void setRecipientsName(String recipientsName) {
		RecipientsName = recipientsName;
	}

	public String getRecipientsMobileNumber() {
		return RecipientsMobileNumber;
	}

	public void setRecipientsMobileNumber(String recipientsMobileNumber) {
		RecipientsMobileNumber = recipientsMobileNumber;
	}

	public String getRecipientsEmail() {
		return RecipientsEmail;
	}

	public void setRecipientsEmail(String recipientsEmail) {
		RecipientsEmail = recipientsEmail;
	}

	public String getDeliveryType() {
		return deliveryType;
	}

	public void setDeliveryType(String deliveryType) {
		this.deliveryType = deliveryType;
	}

	public String getScheduledelivaryDate() {
		return scheduledelivaryDate;
	}

	public void setScheduledelivaryDate(String scheduledelivaryDate) {
		this.scheduledelivaryDate = scheduledelivaryDate;
	}

	@Override
	public String toString() {
		return "PlaceGiftCardOrderDto [giftCard=" + giftCard + ", userId=" + userId + ", giftCardIssueDate="
				+ giftCardIssueDate + ", reloadable=" + reloadable + ", RecipientsName=" + RecipientsName
				+ ", RecipientsMobileNumber=" + RecipientsMobileNumber + ", RecipientsEmail=" + RecipientsEmail
				+ ", receiverAddress=" + receiverAddress + ", deliveryType=" + deliveryType + ", scheduledelivaryDate="
				+ scheduledelivaryDate + "]";
	}

}
