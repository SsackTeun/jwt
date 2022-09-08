package com.github.ssackteun.portal.jwt.controller;

import com.github.ssackteun.portal.jwt.token.IdPasswordLogin;
import com.github.ssackteun.portal.jwt.token.Token;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JWTController {

    @GetMapping("/auth/token")
    public ResponseEntity<Token> getToken(@RequestBody IdPasswordLogin idPasswordLogin){
        Token jwt = new Token();
        jwt.setToken("test");
        return new ResponseEntity<>(jwt, HttpStatus.CREATED);
    }

}
