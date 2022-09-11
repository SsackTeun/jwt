package com.github.ssackteun.portal.jwt.utils;

import io.jsonwebtoken.*;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Component
@Getter
public class JwtTokenProvider {

    private final String secretKey;

    public JwtTokenProvider(@Value("${jwt.secret}") String secretKey) {
        this.secretKey = secretKey;
    }

    public TokenDTO generate(Authentication authentication){

        String authorities = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));

        //Headers
        Map<String, Object> headers = new HashMap<>();
        headers.put("typ", "JWT");
        headers.put("alg", "HS256");

        //Payload
        Map<String, Object> payloads = new HashMap<>();
        payloads.put("userId", authentication.getName());
        payloads.put("Roles", authorities);

        //토큰 유효시간 설정
        Date ext = new Date();
        long expiredTime = 1000 * 60L * 60L * 24L * 14L; // 토큰 유효 시간 14일
        ext.setTime(ext.getTime() + expiredTime);

        //build token
        String jwt = Jwts.builder()
                .setHeader(headers)
                .setClaims(payloads)
                .setExpiration(ext)
                .signWith(SignatureAlgorithm.HS256, secretKey.getBytes())
                .compact();

        return TokenDTO.builder().Token(jwt).build();
    }
}
