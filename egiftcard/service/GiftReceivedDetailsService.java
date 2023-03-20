package com.cg.egiftcard.service;

import java.text.ParseException;
import java.util.List;

import com.cg.egiftcard.dto.GiftReceivedDetailsDto;
import com.cg.egiftcard.entity.GiftReceivedDetails;
import com.cg.egiftcard.exception.UserCustomExceptions;

public interface GiftReceivedDetailsService {

	public List<GiftReceivedDetails> getAllGiftReceivedDetails();

	public GiftReceivedDetails addGiftReceivedDetails(GiftReceivedDetails giftReceivedDetails);

	public GiftReceivedDetails getGiftReceivedDetailsById(Long giftReceivedId);

	public GiftReceivedDetails updateGiftReceivedDetails(GiftReceivedDetailsDto giftReceivedDetailsDto) throws UserCustomExceptions, ParseException;

}
