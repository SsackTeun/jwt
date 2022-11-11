package com.github.ssackteun.portal.jwt.service.member;

import com.github.ssackteun.portal.jwt.dto.MemberInfoDTO;

public interface NormalMemberService<T> {
	//본인정보 조회
	T getMemberInfo(String token);
	//가입
	T createMember(MemberInfoDTO memberInfoDTO) throws Exception;

	//유저정보
	T readMember(MemberInfoDTO memberInfoDTO);

}
