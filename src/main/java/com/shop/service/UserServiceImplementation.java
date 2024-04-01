package com.shop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shop.exception.UserException;
import com.shop.modal.User;
import com.shop.repository.UserRepository;
import com.shop.reqres.CreateUserRequest;

@Service
public class UserServiceImplementation implements UserService {

	UserRepository userRepository;
	
	public UserServiceImplementation(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public User getUserByUserId(Integer userId) throws UserException {
		
		User user = userRepository.getById(userId);
		
		return user;
	}

	@Override
	public List<User> getAllUsers() throws UserException {
		
		List<User> users = userRepository.findAll();
		
		return users;
	}

	@Override
	public User createUser(CreateUserRequest req) throws UserException {
		
		User user = new User();
		
		user.setEmail(req.getEmail());
		user.setFull_name(req.getUsername());
		user.setPassword(req.getPassword());

		return userRepository.save(user);
	}

	
}
