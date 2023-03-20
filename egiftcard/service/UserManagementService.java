package com.cg.egiftcard.service;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.mail.MessagingException;

import com.cg.egiftcard.entity.User;
import com.cg.egiftcard.exception.InvalidInputException;
import com.cg.egiftcard.exception.UserCustomExceptions;

public interface UserManagementService {

	List<User> getAllUsers();

	User getUserByEmailPass(String email, String password) throws UserCustomExceptions, InvalidInputException;

	User updateUserPassword(String email, String oldPassword, String newPassword)
			throws UserCustomExceptions, InvalidInputException, UnsupportedEncodingException, MessagingException;

	List<User> searchUsers(String searchText);

	User getUserById(Long userId) throws UserCustomExceptions;

	User RegisterUser(User user)
			throws UserCustomExceptions, InvalidInputException, UnsupportedEncodingException, MessagingException;

	User updateUser(User user) throws UserCustomExceptions, UnsupportedEncodingException, MessagingException;

	User getUserByEmail(String email) throws InvalidInputException, UserCustomExceptions;

	String deleteUser(User user) throws UserCustomExceptions;

	String deleteUserById(Long userId) throws UserCustomExceptions;
}
