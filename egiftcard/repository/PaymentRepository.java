package com.cg.egiftcard.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.egiftcard.entity.PaymentDetails;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentDetails, Integer> {
	public PaymentDetails findByCardNumber(String cardNumber);

	public List<PaymentDetails> findByNameonthecard(String cardname);

	public PaymentDetails findByUserGiftId(int giftId);

}
