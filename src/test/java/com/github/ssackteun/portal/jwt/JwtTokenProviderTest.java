package com.github.ssackteun.portal.jwt;

import com.github.ssackteun.portal.jwt.utils.JwtTokenProvider;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JwtTokenProviderTest {

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Test
    void getSecret(){
        System.out.println(jwtTokenProvider);
    }
}
