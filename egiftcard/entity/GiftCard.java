package com.cg.egiftcard.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "giftcard")
public class GiftCard {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long giftCardId;

	@Column(name = "giftCardName")
	@NotEmpty
	@Size(max = 100)
	private String giftCardName;
	@Size(max = 100)
	private String brandList;
	
	private float amount;
	
	@Size(max = 100)
	private String aboutGiftCard;

	public GiftCard() {
		super();
	}

	public GiftCard(String giftCardName, String brandList, String aboutGiftCard, float amount) {
		super();
		this.giftCardName = giftCardName;
		this.brandList = brandList;
		this.aboutGiftCard = aboutGiftCard;
		this.amount = amount;
	}

	public Long getGiftCardId() {
		return giftCardId;
	}

	public void setGiftCardId(Long giftCardId) {
		this.giftCardId = giftCardId;
	}

	public String getGiftCardName() {
		return giftCardName;
	}

	public void setGiftCardName(String giftCardName) {
		this.giftCardName = giftCardName;
	}

	public String getBrandList() {
		return brandList;
	}

	public void setBrandList(String brandList) {
		this.brandList = brandList;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public String getAboutGiftCard() {
		return aboutGiftCard;
	}

	public void setAboutGiftCard(String aboutGiftCard) {
		this.aboutGiftCard = aboutGiftCard;
	}

	@Override
	public String toString() {
		return "GiftCard [giftCardId=" + giftCardId + ", giftCardName=" + giftCardName + ", brandList=" + brandList
				+ ", amount=" + amount + ", aboutGiftCard=" + aboutGiftCard + "]";
	}

}
