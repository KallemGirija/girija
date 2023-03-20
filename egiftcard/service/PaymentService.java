package com.cg.egiftcard.service;

import java.util.List;

import com.cg.egiftcard.entity.PaymentDetails;
import com.cg.egiftcard.exception.PaymentCustomExceptions;

public interface PaymentService {

	PaymentDetails addPaymentDetails(PaymentDetails paymentDetails) throws Exception;

	PaymentDetails findPaymentDetailsById(int paymentId) throws PaymentCustomExceptions;

	PaymentDetails updatePaymentDetails(PaymentDetails paymentDetails, int paymentId) throws PaymentCustomExceptions;

	List<PaymentDetails> getAllPaymentDetails();
	
	PaymentDetails getByCardNumber(String cardNumber) throws PaymentCustomExceptions;
	
	List<PaymentDetails> getByNameonthecard(String cardname)throws PaymentCustomExceptions;
	
	PaymentDetails getByUserGiftId(int giftId) throws PaymentCustomExceptions;

}
