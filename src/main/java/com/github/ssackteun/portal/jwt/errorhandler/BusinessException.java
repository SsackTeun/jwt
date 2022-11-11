package com.github.ssackteun.portal.jwt.errorhandler;

import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException{
	private ErrorCode errorCode;
	private String message;

	public BusinessException(ErrorCode errorCode, String message) {
		this.message = message;
		this.errorCode = errorCode;
	}

	public ErrorCode getErrorCode() {
		return errorCode;
	}
}
