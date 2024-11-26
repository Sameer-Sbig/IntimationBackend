package com.sbigeneral.SECUREAPI.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


public class AccountLockedException extends RuntimeException {
	private final int statuscode;
	public AccountLockedException(String message,int statuscode) {
		super(message);
		this.statuscode=statuscode;
	}
	
	public int getStatuscode() {
		return statuscode;
	}

}
