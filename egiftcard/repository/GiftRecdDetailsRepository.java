package com.cg.egiftcard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.egiftcard.entity.GiftReceivedDetails;
@Repository
public interface GiftRecdDetailsRepository extends JpaRepository<GiftReceivedDetails, Long> {

}
