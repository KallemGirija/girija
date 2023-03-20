package com.cg.egiftcard.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "payment")
public class PaymentDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "paymentId")
	private int paymentId;
	@Column(name = "paymentDate")
	@Temporal(TemporalType.DATE)
	private Date paymentDate = new Date(System.currentTimeMillis());
	@Column(name = "paymentAmount")
	private float paymentAmount;
	@Column(name = "nameonthecard")
	@NotEmpty
	@Size(min = 3,max = 100, message = "name should be of minimum 3 character")
	private String nameonthecard;
	@Column(unique = true)
	@NotEmpty
	@Size(max = 20)
	private String cardNumber;
	@Column(name = "cardExpiry")
	private Date cardExpiry;
	@Column(name = "cvv")
	@NotEmpty
	@Size(max = 10)
	private String cvv;

	private int userGiftId;
	@ManyToOne(cascade = CascadeType.MERGE)
//	@JoinColumn(name = "userGiftId")
	private User users;

	public PaymentDetails() {
		super();
	}

	public PaymentDetails(int paymentId, Date paymentDate, float paymentAmount, String nameonthecard, String cardNumber,
			Date cardExpiry, String cvv, int userGiftId, User users) {
		super();
		this.paymentId = paymentId;
		this.paymentDate = paymentDate;
		this.paymentAmount = paymentAmount;
		this.nameonthecard = nameonthecard;
		this.cardNumber = cardNumber;
		this.cardExpiry = cardExpiry;
		this.cvv = cvv;
		this.userGiftId = userGiftId;
		this.users = users;
	}

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public float getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(float paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public String getNameonthecard() {
		return nameonthecard;
	}

	public void setNameonthecard(String nameonthecard) {
		this.nameonthecard = nameonthecard;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public Date getCardExpiry() {
		return cardExpiry;
	}

	public void setCardExpiry(Date cardExpiry) {
		this.cardExpiry = cardExpiry;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public int getUserGiftId() {
		return userGiftId;
	}

	public void setUserGiftId(int userGiftId) {
		this.userGiftId = userGiftId;
	}

	public User getUsers() {
		return users;
	}

	public void setUsers(User users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "PaymentDetails [paymentId=" + paymentId + ", paymentDate=" + paymentDate + ", paymentAmount="
				+ paymentAmount + ", nameOntheCard=" + nameonthecard + ", cardNumber=" + cardNumber + ", cardExpiry="
				+ cardExpiry + ", cvv=" + cvv + ", users=" + users + "]";
	}

}
