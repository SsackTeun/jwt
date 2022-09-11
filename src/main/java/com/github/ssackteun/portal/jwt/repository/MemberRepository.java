package com.github.ssackteun.portal.jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.ssackteun.portal.jwt.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
