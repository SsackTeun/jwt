package com.github.ssackteun.portal.jwt.service.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.ssackteun.portal.jwt.dto.LoginRequestDTO;
import com.github.ssackteun.portal.jwt.entity.CustomUserDetails;
import com.github.ssackteun.portal.jwt.utils.token.JwtTokenProvider;
import com.github.ssackteun.portal.jwt.dto.TokenDTO;

@Service
@Slf4j
@RequiredArgsConstructor
public class TokenAuthService implements AuthService {

    @Autowired
    private AuthenticationManagerBuilder authenticationManagerBuilder;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Override
    @Transactional(readOnly = true)
    public TokenDTO login(LoginRequestDTO loginRequestDTO) throws JsonProcessingException {
        //1. 인증 정보생성
        UsernamePasswordAuthenticationToken authenticationToken = loginRequestDTO.toAuthentication();

        //2. 인증요청 loadByUsername
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);

        //3. 인증객체로 부터 사용자 정보 얻어오기
        CustomUserDetails userInfo = (CustomUserDetails)authentication.getPrincipal();
        log.info(userInfo.toString());

        //3. 인증정보로 JWT 토큰생성
        return jwtTokenProvider.generate(authentication);
    }
}
