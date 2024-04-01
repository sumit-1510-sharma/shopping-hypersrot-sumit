package com.shop.exception;

import java.time.LocalDateTime;



// this class is to only make the response in required format (it is used in GlobalExceptions, which handles
// all the exception)

public class ErrorDetails {

	private String error;
	private String message;
	private LocalDateTime timeStamp;
	
	public ErrorDetails() {
		// TODO Auto-generated constructor stub
	}
	
	public ErrorDetails(String error, String message, LocalDateTime timeStamp) {
		super();
		this.error = error;
		this.message = message;
		this.timeStamp = timeStamp;
	}
	
	
}
