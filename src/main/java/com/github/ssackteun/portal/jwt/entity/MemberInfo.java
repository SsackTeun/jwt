package com.github.ssackteun.portal.jwt.entity;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class MemberInfo {

	@Id
	@Column
	@Type(type = "uuid-char")
	private UUID id;

	@Column
	private String name;

	@Column
	private String phone;

	@Column
	private String position;

	@Column
	private String part;

	@Column
	private String email;

	@Column
	private String isWorking;

	@Column
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startDate;

	@Column
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endDate;

	@Column
	private String isEmailAuth;

	/* @ 각 서비스 접근권한 */
	@Enumerated(EnumType.STRING)
	private Authority authority; //권한

	@Column
	@UpdateTimestamp
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updateAt; //생성일

}
