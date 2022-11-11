package com.github.ssackteun.portal.jwt.utils.token;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.github.ssackteun.portal.jwt.dto.TokenDTO;
import com.github.ssackteun.portal.jwt.entity.CustomUserDetails;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;

import io.jsonwebtoken.security.Keys;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Getter
@Setter
public class JwtTokenProvider {

    private static String secretKey;

    @Value("${jwt.secret}")
    public void setSecretKey(String key){
        secretKey = key;
    }

    public Jws<Claims> parse(String token){
        log.info("key::{}", secretKey);
        return Jwts.parserBuilder()
            .setSigningKey(secretKey.getBytes(StandardCharsets.UTF_8))
            .build()
            .parseClaimsJws(token);
    }

    public TokenDTO generate(Authentication authentication) throws JsonProcessingException {

        //Spring Security - CustomUserDetails
        CustomUserDetails customUserDetails = (CustomUserDetails)authentication.getPrincipal();

        //JWT - Header (알고리즘, 토큰 타입)
        Map<String, Object> headers = new HashMap<>();
        headers.put("typ", "JWT");
        headers.put("alg", "HS256");

        //JWT - Payload (데이터)
        Map<String, Object> payloads = new HashMap<>();
        payloads.put("acct", customUserDetails.getUsername());
        payloads.put("domain", "onware.local");
        //payloads.put("perms", customUserDetails.getAuthorities());

        //권한 정보의 키값 제외하기 위해서
        List<GrantedAuthority> authorities = customUserDetails
            .getAuthorities()
            .stream()
            .map(grantedAuthority -> new SimpleGrantedAuthority(grantedAuthority.getAuthority()))
            .collect(Collectors.toList());

        String[] authority = new String[authorities.size()];
        for(GrantedAuthority a: authorities){
            int i = 0;
            System.out.println(a.getAuthority());
            authority[i] = a.getAuthority();
        }

        //Key
        Key key = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));


        //Build
        String jwt = Jwts.builder()
            .setHeader(headers)
            .setClaims(payloads)
            .claim("perms", authority) // key 값 제외하기 위해서
            .setExpiration(TokenWithDate.createOfExp(Calendar.MINUTE, 360000))
            .setIssuedAt(TokenWithDate.createOfExp(Calendar.MINUTE, 0))
            .signWith(key)
            .compact();

        return TokenDTO
            .builder()
            .Token(jwt)
            .build();
    }
}
