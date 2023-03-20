package com.cg.egiftcard.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.egiftcard.entity.User;
import com.cg.egiftcard.entity.UserGiftDetails;
@Repository
public interface UserGiftDetailsAccountManagementRepository extends JpaRepository<UserGiftDetails, Long> {

	@Query("Select gfd From UserGiftDetails gfd WHERE gfd.user =:user")
	List<UserGiftDetails> getUserGiftOrderHistory(@Param("user") User user);
	
	UserGiftDetails findByUserGiftId(int userGiftId);

}
