package com.cg.egiftcard.service;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import javax.mail.MessagingException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.cg.egiftcard.entity.User;
import com.cg.egiftcard.exception.InvalidInputException;
import com.cg.egiftcard.exception.UserCustomExceptions;
import com.cg.egiftcard.repository.UserRepository;
import com.cg.egiftcard.util.Validations;

@Service
//@Transactional
public  class UserManagementServiceImpl implements UserManagementService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private Validations validator;

	@Autowired
	private NotificationService notifService;

	@Override
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

	@Override
	public User getUserById(Long userId) throws UserCustomExceptions {
		Optional<User> usr = userRepo.findById(userId);
		if (usr.isPresent()) {
			return usr.get();
		}
		throw new UserCustomExceptions("User does not exists", HttpStatus.NOT_FOUND);
	}

	@Override
	public User RegisterUser(User user)
			throws UserCustomExceptions, InvalidInputException, UnsupportedEncodingException, MessagingException {
		if (!validator.isEmailValid(user.getEmail())) {
			throw new InvalidInputException("Invalid email. Try again..!", HttpStatus.UNAUTHORIZED);
		}
		User usr = userRepo.save(user);
		if (usr != null) {
			try {
				notifService.sendDemoNotif(usr.getEmail(), usr.getFirstName(), usr.getLastName(), "register");
			} catch ( Exception e ) {
				e.printStackTrace();
			}
			
			return usr;
		}
		throw new UserCustomExceptions("Cannot Register the user. Try again..!", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	

	@Override
	public User updateUser(User user) throws UserCustomExceptions, UnsupportedEncodingException, MessagingException {
		User usr = userRepo.save(user);
		if (usr != null) {
			try {
				notifService.sendDemoNotif(usr.getEmail(), usr.getFirstName(), usr.getLastName(), "update");

			} catch( Exception e) {
				e.printStackTrace();
				
			}
			return usr;
		}
		throw new UserCustomExceptions("Cannot update the user. Try again..!", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	
	
	@Override
	public User getUserByEmail(String email) throws InvalidInputException, UserCustomExceptions {
		if (!validator.isEmailValid(email)) {
			throw new InvalidInputException("Invalid email. Try again..!", HttpStatus.UNAUTHORIZED);
		}
		User usr = userRepo.getUserByEmail(email);
		if (usr != null) {
			return usr;
		}
		throw new UserCustomExceptions("Invalid email. Try again..!", HttpStatus.UNAUTHORIZED);
	}

	public String deleteUser(User user) throws UserCustomExceptions {
		userRepo.delete(user);
		if (userRepo.findById(user.getUserId()).isPresent()) {
			throw new UserCustomExceptions("Error deleting the user", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return "User successfully deleted..!";
	}

	@Override
	public String deleteUserById(Long userId) throws UserCustomExceptions {
		userRepo.deleteById(userId);
		if (userRepo.findById(userId).isPresent()) {
			throw new UserCustomExceptions("Error deleting the user", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return "User successfully deleted..!";
	}

	@Override
	public User getUserByEmailPass(String email, String password) throws UserCustomExceptions, InvalidInputException {
		if (!validator.isEmailValid(email)) {
			throw new InvalidInputException("Invalid email. Try again..!", HttpStatus.UNAUTHORIZED);
		}

		User usr = userRepo.getUserByEmailAndPassword(email, password);
		if (usr != null) {
			return usr;
		}
		throw new UserCustomExceptions("Invalid email or password. Try again..!", HttpStatus.UNAUTHORIZED);
	}

	@Override
	public User updateUserPassword(String email, String oldPassword, String newPassword)
			throws UserCustomExceptions, InvalidInputException, UnsupportedEncodingException, MessagingException {
		User usr = userRepo.getUserWithOldPass(email, oldPassword);
		if (usr != null) {
			if (Objects.equals(newPassword, oldPassword)) {
				throw new InvalidInputException("old and new password cannot be same. Try again..!",
						HttpStatus.UNAUTHORIZED);
			}
			usr.setPassword(newPassword);
			notifService.sendDemoNotif(usr.getEmail(), usr.getFirstName(), usr.getLastName(), "update");

			return userRepo.save(usr);
		}
		throw new UserCustomExceptions("Old password is incorrect..!", HttpStatus.UNAUTHORIZED);
	}

	@Override
	public List<User> searchUsers(String searchText) {
		List<User> users = new ArrayList<>();
		if (searchText != null && !"".equals(searchText)) {
			users.addAll(userRepo.searchUsersByEmail(searchText));
			users.addAll(userRepo.searchUsersByFirstName(searchText));
			users.addAll(userRepo.searchUsersByLastName(searchText));
		}
		Set<User> set = new LinkedHashSet<>();
		set.addAll(users);
		users.clear();
		users.addAll(set);
		return users;
	}

}
