package com.github.ssackteun.portal.jwt.dto;

import javax.validation.constraints.Email;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.ssackteun.portal.jwt.entity.Authority;
import com.github.ssackteun.portal.jwt.entity.Member;
import com.google.gson.annotations.Expose;

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
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MemberInfoDTO implements PasswordEncoder{
	@Email
	private String userName; // 로그인 아이디

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String password; // 패스워드
	private Authority authority; // 권한정보

	//가입 정보 DTO to Member
	public Member toEntity(){
		return Member.builder()
			.userName(this.userName)
			.authority(this.authority)
			.password(encode(this.password))
			.build();
	}

	//유저 조회 Member to DTO
	public MemberInfoDTO toDto(Member m){
		return MemberInfoDTO.builder()
			.userName(m.getUserName())
			.password(m.getPassword())
			.authority(m.getAuthority())
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
