package com.github.ssackteun.portal.jwt.auth.controller;

import com.github.ssackteun.portal.jwt.auth.entity.LoginRequestDTO;
import com.github.ssackteun.portal.jwt.auth.service.AuthService;
import com.github.ssackteun.portal.jwt.utils.TokenDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
