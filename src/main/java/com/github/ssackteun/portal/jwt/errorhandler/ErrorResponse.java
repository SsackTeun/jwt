package com.github.ssackteun.portal.jwt.errorhandler;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorResponse {
	private final String code;
	private final String message;

	public static ErrorResponse of(String code, String message) {
		return new ErrorResponse(code,message);
	}
}
