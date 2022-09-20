package com.github.ssackteun.portal.jwt.utils;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.github.ssackteun.portal.jwt.dto.TokenDTO;
import com.github.ssackteun.portal.jwt.entity.CustomUserDetails;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;

import io.jsonwebtoken.security.Keys;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Getter
public class JwtTokenProvider {

    private final String secretKey;

    public JwtTokenProvider(
        @Value("${jwt.secret}") String secretKey) {
        this.secretKey = secretKey;
    }

    public Jws<Claims> parse(String token){
        return Jwts.parserBuilder()
            //.deserializeJsonWith(new GsonDeserializer<>(Maps.of()))
            .setSigningKey(secretKey.getBytes(StandardCharsets.UTF_8))
            .build()
            .parseClaimsJws(token);
    }

    public TokenDTO generate(Authentication authentication){

        CustomUserDetails customUserDetails = (CustomUserDetails)authentication.getPrincipal();

        //Headers
        Map<String, Object> headers = new HashMap<>();
        headers.put("typ", "JWT");
        headers.put("alg", "HS256");

        //Payload
        Map<String, Object> payloads = new HashMap<>();
        payloads.put("userid", customUserDetails.getUsername());
        //payloads.put("services", customUserDetails.getAuthorities());
        payloads.put("services", "{\"board\":[\"ROLE_USER\", \"ROLE_ADMIN\"], \"vacation\":[\"ROLE_USER\"]}");
        payloads.put("username", customUserDetails.getName());

        //토큰 유효시간 설정
        Date ext = new Date();
        long expiredTime = 1000 * 60L * 60L * 24L * 14L; // 토큰 유효 시간 14일
        ext.setTime(ext.getTime() + expiredTime);

        Key key = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));

        //build token
        String jwt = Jwts.builder()
                .setHeader(headers)
                .setClaims(payloads)
                .setExpiration(ext)
                .signWith(key)
                .compact();

        return TokenDTO.builder().Token(jwt).build();
    }
}
