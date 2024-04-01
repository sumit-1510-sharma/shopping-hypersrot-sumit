package com.shop.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shop.exception.UserException;
import com.shop.modal.User;
import com.shop.reqres.CreateUserRequest;
import com.shop.service.UserService;

@RestController
public class UserController {
	
	UserService userService;
	
	public UserController(UserService userService) {              //Constructor Injection because it is faster
		this.userService = userService;
	}

	
	@PostMapping("/user/create")
	public ResponseEntity<User> createUserHandler(@RequestBody CreateUserRequest req) throws UserException {
		
		User user = userService.createUser(req);
		
		return new ResponseEntity<User>(user,HttpStatus.ACCEPTED);
	}
}
