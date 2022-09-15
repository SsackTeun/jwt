package com.github.ssackteun.portal.jwt;

import com.github.ssackteun.portal.jwt.utils.JwtTokenProvider;

import org.apache.logging.slf4j.SLF4JLoggerContextFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.GrantedAuthority;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;

@SpringBootTest
public class JwtTokenProviderTest {

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Test
    void getSecret(){
        System.out.println(jwtTokenProvider);
    }

    @Test
    void parser(){
        Jws<Claims> s = jwtTokenProvider.parse("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzZXJ2aWNlcyI6IntcImJvYXJkXCI6W1wiUk9MRV9VU0VSXCIsIFwiUk9MRV9BRE1JTlwiXSwgXCJ2YWNhdGlvblwiOltcIlJPTEVfVVNFUlwiXX0iLCJ1c2VyaWQiOiJzc2Fja3RldW4iLCJ1c2VybmFtZSI6Imp5IiwiZXhwIjoxNjY0MzI4MDgxfQ.IQCejLMAcrX_70VzQ5DetLqbSuxHTQjJwFFvL7fqoiTvdgYwLkT33Htj-jgmESL5vKS-iB1zKOrSuH-6uZuomw");
        System.out.println(s.toString());
    }
}
