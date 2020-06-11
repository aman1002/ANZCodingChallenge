package com.anz.codechallenge.exceptions;

import java.util.Date;

public class ExceptionResponse {
	
	private Date timestamp;
	private String errorCode;
	private String message;
	private String details;
	
	public ExceptionResponse(Date timestamp, String errorCode, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.errorCode = errorCode;
		this.message = message;
		this.details = details;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public String getMessage() {
		return message;
	}
	public String getDetails() {
		return details;
	}
	public String getErrorCode() {
		return errorCode;
	}

}
