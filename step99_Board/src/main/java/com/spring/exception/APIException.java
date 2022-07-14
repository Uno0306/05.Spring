package com.spring.exception;


import lombok.Getter;

@Getter
public class APIException extends RuntimeException{
	private ExceptionEnum error;
	
	public APIException(ExceptionEnum e) {
		super(e.getMessage());
		this.error = e;
	}
	
}
