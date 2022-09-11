package com.github.ssackteun.portal.jwt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.GenerationType;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id; //PK sequence

    @Column
    private String userId; //로그인 아이디

    @Column
    private String password; //패스워드

    @Enumerated(EnumType.STRING)
    private Authority authority; //권한

    @Column
    private String email; //이메일 주소

    @Column
    private String name; //이름

    // @Builder
    // public Member(String userId, String password, Authority authority, String email, String name){
    //     this.userId = userId;
    //     this.password = password;
    //     this.authority = authority;
    //     this.email = email;
    //     this.name = name;
    // }
}
