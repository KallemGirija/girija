package com.cg.egiftcard.controller;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.Map;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.egiftcard.dto.ForgotPasswordDto;
import com.cg.egiftcard.dto.PlaceGiftCardOrderDto;
import com.cg.egiftcard.entity.LoginCred;
import com.cg.egiftcard.entity.User;
import com.cg.egiftcard.exception.GiftCardCustomExceptions;
import com.cg.egiftcard.exception.InvalidInputException;
import com.cg.egiftcard.exception.UserCustomExceptions;
import com.cg.egiftcard.exception.UserGiftDetailsCustomExceptions;
import com.cg.egiftcard.service.UserGiftDetailsAccountManagementService;
import com.cg.egiftcard.service.UserManagementService;
import com.cg.egiftcard.util.CreateResponseEntity;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {

	@Autowired
	private UserManagementService userService;

	@Autowired
	private UserGiftDetailsAccountManagementService userGiftDetailsService;

	@GetMapping()
	public ResponseEntity<Map<String, Object>> getAllUsers() {
		CreateResponseEntity res = new CreateResponseEntity();
		res.setStatus(true);
		res.setMessage("list of users fetched successfully.");
		res.setData(userService.getAllUsers());
		res.setHttpStatus(HttpStatus.OK);
		return res.getResponseEntity();
	}

	@PostMapping("/register")
	public ResponseEntity<Map<String, Object>> userRegister(@RequestBody User user)
			throws UserCustomExceptions, InvalidInputException, UnsupportedEncodingException, MessagingException {
		CreateResponseEntity res = new CreateResponseEntity();
		res.setStatus(true);
		res.setMessage("user registered successfully.");
		res.setData(userService.RegisterUser(user));
		res.setHttpStatus(HttpStatus.CREATED);
		return res.getResponseEntity();
	}

	@PostMapping("/login")
	public ResponseEntity<Map<String, Object>> userLogin(@RequestBody LoginCred body)
			throws UserCustomExceptions, InvalidInputException {
		CreateResponseEntity res = new CreateResponseEntity();
		res.setStatus(true);
		res.setMessage("Login successfull.");
		res.setData(userService.getUserByEmailPass(body.getEmail(), body.getPassword()));
		res.setHttpStatus(HttpStatus.OK);
		return res.getResponseEntity();
	}
	
	@GetMapping("/{userId}/profile")
	public ResponseEntity<Map<String, Object>> userProfile(@PathVariable Long userId) throws UserCustomExceptions {
		CreateResponseEntity res = new CreateResponseEntity();
		res.setStatus(true);
		res.setMessage("profile fetched successfully.");
		res.setData(userService.getUserById(userId));
		res.setHttpStatus(HttpStatus.OK);
		return res.getResponseEntity();
	}

	@PostMapping("/search")
	public ResponseEntity<Map<String, Object>> usersSearch(@RequestParam String searchText)  {
		CreateResponseEntity res = new CreateResponseEntity();
		res.setStatus(true);
		res.setMessage("these are the search results..!.");
		res.setData(userService.searchUsers(searchText));
		res.setHttpStatus(HttpStatus.OK);
		return res.getResponseEntity();
	}

	@PutMapping("/change-password")
	public ResponseEntity<Map<String, Object>> changePassword(@RequestBody ForgotPasswordDto forgotPasswordDto)
			throws UserCustomExceptions, InvalidInputException, UnsupportedEncodingException, MessagingException {
		CreateResponseEntity res = new CreateResponseEntity();
		res.setStatus(true);
		res.setMessage("Password changed successfully..!.");
		res.setData(userService.updateUserPassword(forgotPasswordDto.getEmail(), forgotPasswordDto.getOldPassword(),
				forgotPasswordDto.getNewPassword()));
		res.setHttpStatus(HttpStatus.OK);
		return res.getResponseEntity();
	}

	@GetMapping("/{userId}/view-order-history")
	public ResponseEntity<Map<String, Object>> viewOrderHistory(@PathVariable Long userId) throws UserCustomExceptions {
		CreateResponseEntity res = new CreateResponseEntity();
		res.setStatus(true);
		res.setMessage("User gift order history fetched successfully..!.");
		res.setData(userGiftDetailsService.getUserGiftOrderHistory(userId));
		res.setHttpStatus(HttpStatus.OK);
		return res.getResponseEntity();
	}
	
	@PostMapping({"/user/place-gift-order"})
	public ResponseEntity<Map<String, Object>> placeGiftOrder(@RequestBody PlaceGiftCardOrderDto placeGiftCardOrderDto)
			throws GiftCardCustomExceptions, UserCustomExceptions, UserGiftDetailsCustomExceptions, ParseException,
			UnsupportedEncodingException, MessagingException, InvalidInputException {
		CreateResponseEntity res = new CreateResponseEntity();
		res.setStatus(true);
		res.setMessage("Gift order placed successfully..!.");
		res.setData(userGiftDetailsService.placeGiftCardOrder(placeGiftCardOrderDto));
		res.setHttpStatus(HttpStatus.OK);
		return res.getResponseEntity();
	}


}
