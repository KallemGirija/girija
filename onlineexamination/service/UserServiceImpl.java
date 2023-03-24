package com.cg.onlineexamination.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineexamination.entity.User;
import com.cg.onlineexamination.exception.InvalidInputDataException;
import com.cg.onlineexamination.repository.UserRepository;



@Service
public class UserServiceImpl  implements UserService{
	
	@Autowired
	UserRepository userRepository;

	@Override
	public User registerUser(User user) throws Exception {
		// TODO Auto-generated method stub
		if(user.getFirstName().equals("") || user.getLastName().equals("")) {
			throw new InvalidInputDataException("User name","First Name or Last Name is null");
		}
		
		if(user.getEmailId().equals("")) {
			throw new InvalidInputDataException("Email Id","Email Id cannot be null");
		}
		if(user.getPassword().equals("")) {
			throw new InvalidInputDataException("Password","Password cannot be null");
		}
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User getUserById(int userId) {
		// TODO Auto-generated method stub
		User userFromDB = userRepository.getReferenceById(userId);
		userRepository.getReferenceById(userId);
	
		return userFromDB;
	}

	@Override
	public User updateUser(int userId) {
		// TODO Auto-generated method stub
		User updatedUser = userRepository.getReferenceById(userId);
		userRepository.save(updatedUser);
		return updatedUser;
	}

}
