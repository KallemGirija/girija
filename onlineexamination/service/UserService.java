package com.cg.onlineexamination.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.onlineexamination.entity.User;



@Service
public interface UserService {
	public User registerUser(User user)throws Exception;

	public List<User> getAllUsers();
	
	public User getUserById(int userId);
	
	public User updateUser(int userId);
	
	
}