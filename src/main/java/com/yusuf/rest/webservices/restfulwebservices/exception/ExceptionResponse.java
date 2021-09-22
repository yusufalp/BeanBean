package com.yusuf.rest.webservices.restfulwebservices.exception;

import java.util.Date;

public class ExceptionResponse {
	// timestamp - When the exception happened
	// message - message for the exception
	// detail - detail about the exception
	private Date timestamp;
	private String message;
	private String detail;
	
	// default constructor with fields
	public ExceptionResponse(Date timestamp, String message, String detail) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.detail = detail;
	}
	
	// Getters and Setters 
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	
}
