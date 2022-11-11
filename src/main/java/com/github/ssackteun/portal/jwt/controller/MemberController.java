package com.github.ssackteun.portal.jwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.github.ssackteun.portal.jwt.dto.MemberInfoDTO;
import com.github.ssackteun.portal.jwt.errorhandler.BusinessException;
import com.github.ssackteun.portal.jwt.errorhandler.ErrorCode;
import com.github.ssackteun.portal.jwt.service.member.MemberService;
import com.github.ssackteun.portal.jwt.utils.token.JwtTokenProvider;

import lombok.extern.slf4j.Slf4j;

@RequestMapping("/api")
@RestController
@Slf4j
public class MemberController {

    private final MemberService memberService;

    @Autowired
    MemberController(MemberService memberService){
        this.memberService = memberService;
    }


    //Add Account
    @PostMapping("/member/register")
    public ResponseEntity<?> signup(@RequestBody MemberInfoDTO memberInfoDTO) throws Exception {
        return ResponseEntity.ok(memberService.createMember(memberInfoDTO));
    }

    //유저정보
    @GetMapping(value = "/member")
    public ResponseEntity<?> getUserInfo(@RequestHeader(name = "token") String token){
        MemberInfoDTO memberInfoDTO = memberService.getMemberInfo(token);
        return ResponseEntity.ok(memberService.readMember(memberInfoDTO));
    }
}
