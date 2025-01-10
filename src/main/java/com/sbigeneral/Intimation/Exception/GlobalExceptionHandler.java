package com.sbigeneral.Intimation.Exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.sbigeneral.Intimation.Controller.getPolicyInfoController;

@ControllerAdvice
public class GlobalExceptionHandler {

	private static final Logger logger = LogManager.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(AccountLockedException.class)
	public ResponseEntity<Object> handleAccountLockedException(AccountLockedException ex, WebRequest request) {
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.valueOf(ex.getStatuscode()));
	}

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<Object> handleUsernameNotFoundException(UserNotFoundException ex, WebRequest request) {
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}

	/*
	 * @ExceptionHandler(Exception.class) public ResponseEntity<String>
	 * handleException(Exception e) {
	 * logger.error("Unhandled exception occurred: {}", e.getMessage(), e); return
	 * ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
	 * body("Internal Server Error"); }
	 */
}