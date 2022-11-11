package com.github.ssackteun.portal.jwt.service.member;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.github.ssackteun.portal.jwt.dto.MemberInfoDTO;
import com.github.ssackteun.portal.jwt.entity.Member;
import com.github.ssackteun.portal.jwt.repository.MemberRepository;
import com.github.ssackteun.portal.jwt.utils.token.JwtTokenProvider;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MemberService implements NormalMemberService<MemberInfoDTO> {

	private final MemberRepository memberRepository;

	@Autowired
	MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	@Override
	public MemberInfoDTO getMemberInfo(String token) {
		String user = (String)new JwtTokenProvider().parse(token).getBody().get("acct");
		log.info("token's Owner::{}", user);

		// 유저 정보 체크
		Optional<Member> member = Optional.of(memberRepository.findByUserName(user)).get();
		if (!member.isPresent()) {

		}
		return new MemberInfoDTO().toDto(member.get());
	}

	/**
	 * Member is Entity
	 * 1. toEntity(DTO) -> Member
	 * 2. save(Member) -> return Member
	 * 3. toDto(Member) -> dto
	 * **/
	@Override
	public MemberInfoDTO createMember(MemberInfoDTO memberInfoDTO) throws Exception {
		// 파라미터 체크
		if(memberInfoDTO.getUserName().isEmpty()){
			throw new NullPointerException("유저 정보가 입력되지 않음");
		}
		Optional<Member> member = memberRepository.findByUserName(memberInfoDTO.getUserName());
		if(member.isPresent()){
			throw new IllegalArgumentException("이미 존재하는 유저");
		}
		return memberInfoDTO.toDto(memberRepository.save(memberInfoDTO.toEntity()));
	}

	@Override
	public MemberInfoDTO readMember(MemberInfoDTO memberInfoDTO) {
		// 파라미터 검사
		if(memberInfoDTO.getUserName().isEmpty()){
			throw new NullPointerException("유저 정보가 입력되지 않음");
		}
		return memberInfoDTO.toDto(memberRepository.findByUserName(memberInfoDTO.getUserName()).orElse(null));
	}
}
