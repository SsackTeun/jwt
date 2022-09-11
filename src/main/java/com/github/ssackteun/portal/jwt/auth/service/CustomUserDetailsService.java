package com.github.ssackteun.portal.jwt.auth.service;

import com.github.ssackteun.portal.jwt.auth.entity.Member;
import com.github.ssackteun.portal.jwt.auth.repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

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
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        return authRepository.findByUserId(userId)
                .map(this::customUserDetails)
                .orElseThrow(() -> new UsernameNotFoundException(userId + " 를 찾을 수 없습니다"));
    }

    private UserDetails customUserDetails(Member member){
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(member.getAuthority().toString());
        return new User(String.valueOf(member.getUserId()), member.getPassword(), Collections.singleton(grantedAuthority) );
    }
}
