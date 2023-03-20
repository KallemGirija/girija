package com.cg.egiftcard.service;

import java.util.List;

import com.cg.egiftcard.entity.GiftCard;
import com.cg.egiftcard.exception.GiftCardCustomExceptions;

public interface GiftCardManagementService {
	List<GiftCard> getAllGiftCards();

	GiftCard addGiftCard(GiftCard giftCard) throws GiftCardCustomExceptions;

	GiftCard updateGiftCard(GiftCard GiftCard) throws GiftCardCustomExceptions;

	GiftCard getGiftCardById(Long GiftCardId) throws GiftCardCustomExceptions;

	List<GiftCard> getGiftCardName(String giftCardName) throws GiftCardCustomExceptions;

	String deleteGiftCardById(Long GiftCardId) throws GiftCardCustomExceptions;

}
