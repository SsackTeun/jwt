package com.github.ssackteun.portal.jwt.service.auth;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.github.ssackteun.portal.jwt.entity.CustomUserDetails;
import com.github.ssackteun.portal.jwt.entity.Member;
import com.github.ssackteun.portal.jwt.repository.AuthRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;



@Service
@Slf4j
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private AuthRepository authRepository;

    @Autowired
    public CustomUserDetailsService(AuthRepository authRepository){
        this.authRepository = authRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        log.info("username::{}", userName);
        return authRepository.findByUserName(userName)
                .map(this::customUserDetails)
                .orElseThrow(() -> new UsernameNotFoundException(userName + " 를 찾을 수 없습니다"));
    }

    private UserDetails customUserDetails(Member member){
        log.info("member::{}", member);
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(member.getAuthority().toString());
        return new CustomUserDetails(
            member.getUserName(),
            member.getPassword(),
            Collections.singleton(grantedAuthority));
    }
}
