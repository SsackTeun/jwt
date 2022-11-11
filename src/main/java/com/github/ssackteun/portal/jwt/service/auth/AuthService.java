package com.github.ssackteun.portal.jwt.service.auth;

import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.ssackteun.portal.jwt.dto.LoginRequestDTO;
import com.github.ssackteun.portal.jwt.dto.TokenDTO;

public interface AuthService {
    TokenDTO login(LoginRequestDTO loginRequestDTO) throws JsonProcessingException;
}
