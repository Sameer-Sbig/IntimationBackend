package com.sbigeneral.Intimation.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException{
	public UserNotFoundException() {
		// TODO Auto-generated constructor stub
	}
	
	public UserNotFoundException(String msg) {
		super(msg);
	}
	
	

}
