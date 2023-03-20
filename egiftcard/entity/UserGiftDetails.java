package com.cg.egiftcard.entity;

import java.time.LocalDate;
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
@Table(name = "userGiftDetails")
public class UserGiftDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userGiftId;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userId")
	private User user;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "giftCardId")
	private GiftCard giftCard;

	private float giftCardAmount;
	private Date giftCardIssueDate;
	private boolean reloadable;
	@Size(max = 100)
	private String recipientsName;
	@Size(max = 10)
	private String recipientsMobileNumber;
	@Size( max = 100)
	private String recipientsEmail;
	@Size( max = 10)
	private String deliveryType;
	private LocalDate scheduledelivary;

//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "personalizeId")
//	private Personalize personalize;

	public UserGiftDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserGiftDetails(Long userGiftId, User user, GiftCard giftCard, float giftCardAmount, Date giftCardIssueDate,
			boolean reloadable, String recipientsName, String recipientsMobileNumber, String recipientsEmail,
			String deliveryType, LocalDate scheduledelivary) {
		super();
		this.userGiftId = userGiftId;
		this.user = user;
		this.giftCard = giftCard;
		this.giftCardAmount = giftCardAmount;
		this.giftCardIssueDate = giftCardIssueDate;
		this.reloadable = reloadable;
		this.recipientsName = recipientsName;
		this.recipientsMobileNumber = recipientsMobileNumber;
		this.recipientsEmail = recipientsEmail;
		this.deliveryType = deliveryType;
		this.scheduledelivary = scheduledelivary;
		//this.personalize = personalize;
	}

	public Long getUserGiftId() {
		return userGiftId;
	}

	public void setUserGiftId(Long userGiftId) {
		this.userGiftId = userGiftId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public GiftCard getGiftCard() {
		return giftCard;
	}

	public void setGiftCard(GiftCard giftCard) {
		this.giftCard = giftCard;
	}

	public float getGiftCardAmount() {
		return giftCardAmount;
	}

	public void setGiftCardAmount(float giftCardAmount) {
		this.giftCardAmount = giftCardAmount;
	}

	public Date getGiftCardIssueDate() {
		return giftCardIssueDate;
	}

	public void setGiftCardIssueDate(Date giftCardIssueDate) {
		this.giftCardIssueDate = giftCardIssueDate;
	}

	public boolean isReloadable() {
		return reloadable;
	}

	public void setReloadable(boolean reloadable) {
		this.reloadable = reloadable;
	}

	public String getRecipientsName() {
		return recipientsName;
	}

	public void setRecipientsName(String recipientsName) {
		this.recipientsName = recipientsName;
	}

	public String getRecipientsMobileNumber() {
		return recipientsMobileNumber;
	}

	public void setRecipientsMobileNumber(String recipientsMobileNumber) {
		this.recipientsMobileNumber = recipientsMobileNumber;
	}

	public String getRecipientsEmail() {
		return recipientsEmail;
	}

	public void setRecipientsEmail(String recipientsEmail) {
		this.recipientsEmail = recipientsEmail;
	}

	public String getDeliveryType() {
		return deliveryType;
	}

	public void setDeliveryType(String deliveryType) {
		this.deliveryType = deliveryType;
	}

	public LocalDate getScheduledelivary() {
		return scheduledelivary;
	}

	public void setScheduledelivary(LocalDate scheduledelivary) {
		this.scheduledelivary = scheduledelivary;
	}

//	public Personalize getPersonalize() {
//		return personalize;
//	}
//
//	public void setPersonalize(Personalize personalize) {
//		this.personalize = personalize;
//	}

	@Override
	public String toString() {
		return "UserGiftDetails [userGiftId=" + userGiftId + ", user=" + user + ", giftCard=" + giftCard
				+ ", giftCardAmount=" + giftCardAmount + ", giftCardIssueDate=" + giftCardIssueDate + ", reloadable="
				+ reloadable + ", recipientsName=" + recipientsName + ", recipientsMobileNumber="
				+ recipientsMobileNumber + ", recipientsEmail=" + recipientsEmail + ", deliveryType=" + deliveryType
				+ ", scheduledelivary=" + scheduledelivary + "]";
	}
}
