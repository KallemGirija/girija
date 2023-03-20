package com.cg.egiftcard.service;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;

import com.cg.egiftcard.dto.PlaceGiftCardOrderDto;
import com.cg.egiftcard.entity.GiftCard;
import com.cg.egiftcard.entity.UserGiftDetails;
import com.cg.egiftcard.exception.GiftCardCustomExceptions;
import com.cg.egiftcard.exception.InvalidInputException;
import com.cg.egiftcard.exception.UserCustomExceptions;
import com.cg.egiftcard.exception.UserGiftDetailsCustomExceptions;

public interface UserGiftDetailsAccountManagementService {

	List<UserGiftDetails> getAllUserGiftDetails();

	List<UserGiftDetails> getUserGiftOrderHistory(Long userId) throws UserCustomExceptions;

	UserGiftDetails getUserGiftDetails(Long userGiftDetailsId) throws UserGiftDetailsCustomExceptions;

	UserGiftDetails addUserGiftDetails(UserGiftDetails userGiftDetails) throws UserGiftDetailsCustomExceptions;

	UserGiftDetails updateUserGiftDetails(UserGiftDetails userGiftDetails) throws UserGiftDetailsCustomExceptions;

	String deleteUserGiftDetailsById(Long userGiftDetailsId) throws UserGiftDetailsCustomExceptions;

	GiftCard placeGiftCardOrder(PlaceGiftCardOrderDto placeGiftCardOrderDto)throws GiftCardCustomExceptions, UserCustomExceptions, UserGiftDetailsCustomExceptions, ParseException,
	UnsupportedEncodingException, MessagingException, InvalidInputException;

}
