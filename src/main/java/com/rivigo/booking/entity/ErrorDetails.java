package com.rivigo.booking.entity;

import com.rivigo.booking.exception.CustomValidationException;

public class ErrorDetails {

	private String errorCode;
	private String errorReason;
	private String errorMessage;
	
	
	
	
	public ErrorDetails(String errorCode, String errorReason, String errorMessage) {
		super();
		this.errorCode = errorCode;
		this.errorReason = errorReason;
		this.errorMessage = errorMessage;
	}
	
	
	public static ErrorDetails getInternalServerError()
	{
		return new ErrorDetails("500", "Internal Server Error", "Some internal error occurred, please try after some time");
	}
	
	public static ErrorDetails getInternalServerError(Exception e)
	{
		return new ErrorDetails("500", "Internal Server Error", "Some internal error occurred, please try after some time. Exception is as follows: "+e.getMessage());
	}
	
	public static ErrorDetails getUnAuthorized()
	{
		return new ErrorDetails("401","User Not Authorized","User Not Authorized");
	}
		
	public static ErrorDetails getCustomValidationError(CustomValidationException cve)
	{
		return new ErrorDetails("500", "Custom Validation Error. Exception is as follows: "+cve.getMessage(), "Custom Validation Error. Exception is as follows: "+cve.getMessage());
	}
	
	public static ErrorDetails BADREQUEST()
	{
		return new ErrorDetails("400", "Bad Request", "Please Re-check API or Paramteres ");
	}	
	
	
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorReason() {
		return errorReason;
	}
	public void setErrorReason(String errorReason) {
		this.errorReason = errorReason;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}


	


	
}
