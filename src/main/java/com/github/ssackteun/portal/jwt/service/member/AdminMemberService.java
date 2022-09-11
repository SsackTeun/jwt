package com.github.ssackteun.portal.jwt.service.member;

public interface AdminMemberService<T>{
	T createAdminMember();
	T deleteAdminMember();
	T updateAdminMember();
	T getMemberList();
}
