package com.github.ssackteun.portal.jwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.ssackteun.portal.jwt.dto.LoginRequestDTO;
import com.github.ssackteun.portal.jwt.dto.TokenDTO;
import com.github.ssackteun.portal.jwt.service.auth.AuthService;

import lombok.extern.slf4j.Slf4j;


/**
 * if request with id, password
 * when login
 * then get jwtToken
 * **/
@Slf4j
@RestController
public class AuthController {

    private final AuthService authService;

    @Autowired
    AuthController(AuthService authService){
        this.authService = authService;
    }

    @GetMapping("/auth/token")
    public ResponseEntity<TokenDTO> getToken(@RequestBody LoginRequestDTO loginRequestDTO){
        return ResponseEntity.ok(authService.login(loginRequestDTO));
    }
}
