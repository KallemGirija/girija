package com.cg.egiftcard.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.egiftcard.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	@Query("From User u WHERE u.email =:uEmail AND u.password =:uPass")
	User getUserByEmailAndPassword(@Param("uEmail") String email, @Param("uPass") String password);

	@Query("From User u WHERE u.password =:oldPass AND u.email =:uEmail")
	User getUserWithOldPass(@Param("uEmail") String email, @Param("oldPass") String oldPassword);

	@Query("SELECT u FROM User u WHERE u.firstName LIKE %:firstName%")
	List<User> searchUsersByFirstName(@Param("firstName") String firstName);

	@Query("SELECT u FROM User u WHERE u.lastName LIKE %:lastName%")
	List<User> searchUsersByLastName(@Param("lastName") String lastName);

	@Query("SELECT u FROM User u WHERE u.email LIKE %:email%")
	List<User> searchUsersByEmail(@Param("email") String email);

	@Query("From User u WHERE u.email =:uEmail")
	User getUserByEmail(@Param("uEmail") String email);
}
