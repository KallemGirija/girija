package com.cg.egiftcard.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.egiftcard.entity.GiftCard;

@Repository
public interface GiftCardManagementRepository extends JpaRepository<GiftCard, Long> {
	@Query(value = "select g from GiftCard g where g.giftCardName= ?1")
	public List<GiftCard> findGiftCardName(String giftCardName);


}
