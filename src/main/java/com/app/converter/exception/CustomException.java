package com.app.converter.exception;

import lombok.Getter;
import lombok.Setter;

public class CustomException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Getter @Setter
	private String errorCode;
	
	@Getter @Setter
	private String errorMessage;
	public CustomException( String errorCode, String errorMessage) {
		super(errorMessage);
		this.errorCode=errorCode;
		this.errorMessage=errorMessage;
	}
	
	
}
