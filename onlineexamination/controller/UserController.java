package com.cg.onlineexamination.controller;

import java.util.ArrayList;
import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineexamination.dto.Userdto;
import com.cg.onlineexamination.entity.User;
import com.cg.onlineexamination.service.UserService;
import com.cg.onlineexamination.util.UserDtoConvertor;

@RestController
@RequestMapping
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:2004"},allowedHeaders="*")
public class UserController {
	
	@Autowired
	UserService userService;

	@Autowired
	UserDtoConvertor dtoConvertor;

	public UserController() {
		//logger.info("User Controller Called");
		System.err.println("User Controller Called");

	}

	@PostMapping("/add")

	public ResponseEntity<Userdto> saveUser(@RequestBody User user) throws Exception {

		User savedUser = userService.registerUser(user);
		//logger.info("----> User Saved <----" + savedUser);

		Userdto dto = dtoConvertor.getUserdto(savedUser);

		return new ResponseEntity<Userdto>(dto, HttpStatus.OK);

	}

	@GetMapping("/list")
	public ResponseEntity<List<Userdto>> getAllUsers() {

		List<User> allUsersInDB = userService.getAllUsers();

		List<Userdto> dtoList = new ArrayList<>();
		for (User user : allUsersInDB) {

			Userdto dto = dtoConvertor.getUserdto(user);
			dtoList.add(dto);
		}

		return new ResponseEntity<List<Userdto>>(dtoList, HttpStatus.OK);
	}

	
	

	@GetMapping("/userbyid/{userId}")

	public ResponseEntity<Userdto> getUserById(@PathVariable int userId) throws Exception {
		User userFromDB = userService.getUserById(userId);
		if (userFromDB != null) {
			Userdto dto = dtoConvertor.getUserdto(userFromDB);
			return new ResponseEntity<Userdto>(dto, HttpStatus.OK);
		} else
			return null;
	}

	@PutMapping("/updateuser/{userId}")

	public String updatedUser(@PathVariable int userId) {

		User updatedUser = userService.getUserById(userId);
		return updatedUser.toString();
	}


}


