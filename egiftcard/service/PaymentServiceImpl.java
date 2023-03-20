package com.cg.egiftcard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.egiftcard.entity.PaymentDetails;
import com.cg.egiftcard.exception.PaymentCustomExceptions;
import com.cg.egiftcard.repository.PaymentRepository;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private PaymentRepository paymentRepository;

	@Override
	public PaymentDetails addPaymentDetails(PaymentDetails paymentDetails) throws Exception {
		// TODO Auto-generated method stub
		return paymentRepository.save(paymentDetails);
	}

	@Override
	public PaymentDetails findPaymentDetailsById(int paymentId) throws PaymentCustomExceptions {

		return paymentRepository.findById(paymentId)
				.orElseThrow(() -> new PaymentCustomExceptions("Payment doesn't exists " + paymentId));
	}

	@Override
	public PaymentDetails updatePaymentDetails(PaymentDetails paymentDetails, int paymentId)
			throws PaymentCustomExceptions {
		PaymentDetails pd = paymentRepository.findById(paymentId)
				.orElseThrow(() -> new PaymentCustomExceptions("Payment doesn't exists " + paymentId));
		paymentRepository.delete(pd);
		return paymentRepository.save(pd);
	}

	@Override
	public List<PaymentDetails> getAllPaymentDetails() {

		return paymentRepository.findAll();
	}

	@Override
	public PaymentDetails getByCardNumber(String cardNumber) throws PaymentCustomExceptions {
		try {
			if(paymentRepository.findByCardNumber(cardNumber)==null)
				throw new PaymentCustomExceptions(cardNumber);
		}
		catch(PaymentCustomExceptions e) {
			throw e;
		}
		return paymentRepository.findByCardNumber(cardNumber);
	}

	@Override
	public List<PaymentDetails> getByNameonthecard(String cardname) throws PaymentCustomExceptions {
		try {
			if(paymentRepository.findByNameonthecard(cardname).isEmpty())
				throw new PaymentCustomExceptions(cardname);
			
		}
		catch (PaymentCustomExceptions e) {
			throw e;
			
		}
		return paymentRepository.findByNameonthecard(cardname);
	}

	@Override
	public PaymentDetails getByUserGiftId(int giftId) throws PaymentCustomExceptions {
		try {
			if(paymentRepository.findByUserGiftId(giftId)==null)
				throw new PaymentCustomExceptions(null);
		}
		catch(PaymentCustomExceptions e) {
			throw e;
		}
		return paymentRepository.findByUserGiftId(giftId);
	}
	

}
