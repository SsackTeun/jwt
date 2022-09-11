package com.github.ssackteun.portal.jwt.service.member;

import com.github.ssackteun.portal.jwt.dto.MemberInfoDTO;

public interface NormalMemberService<T> {
	//본인정보 조회
	T getMemberInfo();
	//가입
	T createMember(MemberInfoDTO memberInfoDTO);
}
