package com.github.ssackteun.portal.jwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.ssackteun.portal.jwt.dto.MemberInfoDTO;
import com.github.ssackteun.portal.jwt.service.member.MemberService;

@RestController
public class MemberController {

    private final MemberService memberService;

    @Autowired
    MemberController(MemberService memberService){
        this.memberService = memberService;
    }


    //Add Account
    @PostMapping("/member")
    public ResponseEntity<?> signup(@RequestBody MemberInfoDTO memberInfoDTO){
        return ResponseEntity.ok(memberService.createMember(memberInfoDTO));
    }

    //유저정보
    @GetMapping("/member")
    public ResponseEntity<?> getUserInfo(){
        //return ResponseEntity.ok();
        return null;
    }
}
