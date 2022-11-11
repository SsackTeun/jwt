package com.github.ssackteun.portal.jwt.errorhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

	@ExceptionHandler(MissingRequestHeaderException.class)
	public ResponseEntity<?> handleMissingRequestHeaderException(MissingRequestHeaderException e){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErrorResponse.of("401", e.getMessage()));
	}
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<?> handleIllegalArgumentException(IllegalArgumentException e){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErrorResponse.of("401", e.getMessage()));
	}
}

