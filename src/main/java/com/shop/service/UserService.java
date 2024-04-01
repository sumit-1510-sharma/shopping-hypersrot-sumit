package com.shop.service;

import java.util.List;

import com.shop.exception.UserException;
import com.shop.modal.User;
import com.shop.reqres.CreateUserRequest;

public interface UserService {
	
	public User createUser(CreateUserRequest req) throws UserException;

	public User getUserByUserId(Integer userId) throws UserException;
	
	public List<User> getAllUsers() throws UserException;
}
