package com.spring.entity;

import org.springframework.http.HttpStatus;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class APIExceptionEntity {
	// DB가 아닌 Web 상에서 왔다갔다
	private String errorCode;
	private String errorMessage;
	
	@Builder
	public APIExceptionEntity(HttpStatus status, String errorCode, String errorMessage) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
}
