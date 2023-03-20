package com.cg.egiftcard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.egiftcard.entity.PaymentDetails;
import com.cg.egiftcard.exception.PaymentCustomExceptions;
import com.cg.egiftcard.service.PaymentService;

@RestController
@RequestMapping("/payment")
@CrossOrigin(origins = "*")
public class PaymentController {

	@Autowired
	private PaymentService paymentService;

	@PostMapping("/addpayment")
	public ResponseEntity<PaymentDetails> addPaymentDetails(@RequestBody PaymentDetails paymentDetails)
			throws Exception {
		return new ResponseEntity<PaymentDetails>(paymentService.addPaymentDetails(paymentDetails), HttpStatus.CREATED);
	}

	//@PutMapping("/update-payment/{paymentId}")
	public ResponseEntity<PaymentDetails> updatePaymentDetails(@RequestBody PaymentDetails paymentDetails,
			@PathVariable int paymentId) throws PaymentCustomExceptions {
		return ResponseEntity.ok(paymentService.updatePaymentDetails(paymentDetails, paymentId));
	}

	@GetMapping("/show-payment")
	public ResponseEntity<List<PaymentDetails>> showPayments() {
		return ResponseEntity.ok(paymentService.getAllPaymentDetails());
	}

	@GetMapping("/find-payment-by-id/{paymentId}")
	public ResponseEntity<PaymentDetails> findPaymentById(@PathVariable int paymentId) throws PaymentCustomExceptions {
		return ResponseEntity.ok(paymentService.findPaymentDetailsById(paymentId));
	}
	@GetMapping("/getByNameonthecard/{cardname}")
	List<PaymentDetails> getByNameonthecard(@PathVariable("cardname") String cardname)throws PaymentCustomExceptions{
		return paymentService.getByNameonthecard(cardname);
	}
	@GetMapping("/getByCardNumber/{cardNumber}")
	PaymentDetails getByCardNumber(@PathVariable("cardNumber") String cardNumber) throws PaymentCustomExceptions {
	return paymentService.getByCardNumber(cardNumber);

	}
	@GetMapping("/getByUserGiftId/{giftId}")
	PaymentDetails getByUserGiftId(@PathVariable("giftId") int giftId) throws PaymentCustomExceptions{
		return paymentService.getByUserGiftId(giftId);
	}
	
}


   