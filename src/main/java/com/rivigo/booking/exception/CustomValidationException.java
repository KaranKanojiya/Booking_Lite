package com.rivigo.booking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.OK)
public class CustomValidationException extends Exception{
	
	private String errorCode;

	private static final long serialVersionUID = 1L;
	
	public CustomValidationException(String validationMessage) {
		super(validationMessage);
	}
	
	public CustomValidationException(String errorCode, String validationMessage) {
		super(validationMessage);
		this.errorCode = errorCode;
		
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	
	
	

}
