package com.github.ssackteun.portal.jwt.service.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.ssackteun.portal.jwt.dto.MemberInfoDTO;
import com.github.ssackteun.portal.jwt.entity.Member;
import com.github.ssackteun.portal.jwt.repository.MemberRepository;

@Service
public class MemberService implements NormalMemberService<MemberInfoDTO> {

	private final MemberRepository memberRepository;

	@Autowired
	MemberService(MemberRepository memberRepository){
		this.memberRepository = memberRepository;
	}

	@Override
	public MemberInfoDTO getMemberInfo() {
		return null;
	}

	/**
	 * Member is Entity
		 * 1. toEntity(DTO) -> Member
		 * 2. save(Member) -> return Member
		 * 3. toDto(Member) -> dto
	 * **/
	@Override
	public MemberInfoDTO createMember(MemberInfoDTO memberInfoDTO) {
		return memberInfoDTO.toDto(memberRepository.save(memberInfoDTO.toEntity(memberInfoDTO)));
	}
}
