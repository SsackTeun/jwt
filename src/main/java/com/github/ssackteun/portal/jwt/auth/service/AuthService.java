package com.github.ssackteun.portal.jwt.auth.service;

import com.github.ssackteun.portal.jwt.auth.entity.LoginRequestDTO;
import com.github.ssackteun.portal.jwt.auth.repository.AuthRepository;
import com.github.ssackteun.portal.jwt.utils.JwtTokenProvider;
import com.github.ssackteun.portal.jwt.utils.TokenDTO;
import jdk.nashorn.internal.parser.Token;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthService implements AuthServiceInterface {

    @Autowired
    private AuthenticationManagerBuilder authenticationManagerBuilder;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Override
    @Transactional(readOnly = true)
    public TokenDTO login(LoginRequestDTO loginRequestDTO) {
        //0. 로그인
        UserDetails user = customUserDetailsService.loadUserByUsername(loginRequestDTO.getUserId());
        log.info("Login : " + user.getUsername() + "\n password: " + user.getPassword() + " \n authority : " + user.getAuthorities());

        //1. UsernamePasswordAuthenticationFilter
        UsernamePasswordAuthenticationToken authenticationToken = loginRequestDTO.toAuthentication();

        //2. 검증
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);

        //3. 인증정보로 JWT 토큰생성
        return jwtTokenProvider.generate(authentication);
    }
}
