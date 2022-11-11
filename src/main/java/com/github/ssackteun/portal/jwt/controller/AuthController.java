package com.github.ssackteun.portal.jwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.ssackteun.portal.jwt.dto.LoginRequestDTO;
import com.github.ssackteun.portal.jwt.dto.TokenDTO;
import com.github.ssackteun.portal.jwt.service.auth.TokenAuthService;

import lombok.extern.slf4j.Slf4j;


/**
 * if request with id, password
 * when login
 * then get jwtToken
 * **/
@Slf4j
@RestController
@RequestMapping("/api")
public class AuthController {

    private final TokenAuthService tokenAuthService;

    @Autowired
    AuthController(TokenAuthService tokenAuthService){
        this.tokenAuthService = tokenAuthService;
    }

    @PostMapping("/login")
    public ResponseEntity<TokenDTO> getToken(@RequestBody LoginRequestDTO loginRequestDTO) throws
        JsonProcessingException {
        log.info("login::{}", loginRequestDTO);
        //로그인
        TokenDTO tokenDTO = tokenAuthService.login(loginRequestDTO);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("token", tokenDTO.getToken());

        return new ResponseEntity(tokenDTO, httpHeaders, 200);
    }
}
