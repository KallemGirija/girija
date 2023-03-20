package com.cg.egiftcard.service;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.mail.MessagingException;

import com.cg.egiftcard.entity.GiftReceivedDetails;

public interface NotificationService {

	List<GiftReceivedDetails> getAllGiftReceivedDetails();

//	List<GiftRedeemDetails> getAllGiftRedeemDetails();
//
//	GiftRedeemDetails sendGiftRedeemDetailsNotification(GiftRedeemDetails giftRedeemDetails);

	GiftReceivedDetails sendGiftReceivedDetailsNotification(GiftReceivedDetails giftReceivedDetails);

	String sendDemoNotif(String email, String firstname, String lastName, String type) throws MessagingException, UnsupportedEncodingException;

	String sendOnRegisterMail(String email, String firstname, String lastName)
			throws UnsupportedEncodingException, MessagingException;

}
