package com.github.ssackteun.portal.jwt.errorhandler;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCode {
	//400 BAD_REQUEST 잘못된 요청
	INVALID_PATTERN_USER_NAME(400, "400", "올바른 형식의 값이 아님"),
	NOT_AUTHORIZED(401, "401","인증 정보 없음"),
	INTERNAL_SERVER_ERROR(500, "500","서버 내부 에러"),
	INVALID_INPUT_VALUE(400, "400", "올바른 형식의 값이 아님");

	//404 NOT_FOUND 잘못된 리소스 접근
	// DISPLAY_NOT_FOUND(404, "존재하지 않는 전시회 ID 입니다."),
	// FAIR_NOT_FOUND(404, "존재하지 않는 박람회 ID 박람회입니다."),
	// FESTIVAL_NOT_FOUND(404, "존재하지 않는 페스티벌 ID 페스티벌입니다."),
	// SAVED_DISPLAY_NOT_FOUND(404, "저장하지 않은 전시회입니다."),
	// SAVED_FAIR_NOT_FOUND(404, "저장하지 않은 박람회입니다."),
	// SAVED_FESTIVAL_NOT_FOUND(404, "저장하지 않은 페스티벌입니다."),
	//
	// //409 CONFLICT 중복된 리소스
	// ALREADY_SAVED_DISPLAY(409, "이미 저장한 전시회입니다."),
	// ALREADY_SAVED_FAIR(409, "이미 저장한 박람회입니다."),
	// ALREADY_SAVED_FESTIVAL(409, "이미 저장한 페스티벌입니다."),
	//
	// //500 INTERNAL SERVER ERROR

	private final int status; //header
	private final String code; //payload
	private final String message;
}
