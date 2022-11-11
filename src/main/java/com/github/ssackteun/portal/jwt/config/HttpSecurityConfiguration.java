package com.github.ssackteun.portal.jwt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class HttpSecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .httpBasic().disable() //기본설정 안함
            .csrf().disable() // rest api csrf 보안 x
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) //세션 사용하지 않음
            .and()
            .authorizeRequests() // request 에 대한 처리
            .antMatchers("/api/login").permitAll();
        return http.build();
    }
}
