package com.app.converter.exception.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.app.converter.exception.CustomException;

@ControllerAdvice
public class ExceptionControllerAdvice {
	
	private static final Logger logger = LoggerFactory.getLogger(ExceptionControllerAdvice.class);
	
	@ExceptionHandler(CustomException.class)
	public ResponseEntity<ErrorResponse> exceptionHandler(CustomException ex) {
		ErrorResponse error = new ErrorResponse();
		error.setMessage(ex.getMessage());
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.OK);
		
	}

}
