package com.github.ssackteun.portal.jwt.dto;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.github.ssackteun.portal.jwt.entity.Authority;
import com.github.ssackteun.portal.jwt.entity.Member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberInfoDTO implements PasswordEncoder{
	private String userId; // 로그인 아이디

	private String password; // 패스워드
	private String email; //이메일 주소
	private Authority authority; // 권한정보
	private String name; //이름

	//가입 정보 DTO to Member
	public Member toEntity(MemberInfoDTO m){
		return Member.builder()
			.email(m.getEmail())
			.name(m.getName())
			.authority(m.getAuthority())
			.password(encode(m.password))
			.userId(m.getUserId())
			.build();
	}

	//유저 조회 Member to DTO
	public MemberInfoDTO toDto (Member m){
		return MemberInfoDTO.builder()
			.userId(m.getUserId())
			.name(m.getName())
			.authority(m.getAuthority())
			.email(m.getEmail())
			.build();
	}

	@Override
	public String encode(CharSequence rawPassword) {
		return new BCryptPasswordEncoder().encode(rawPassword);
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		return false;
	}
}
