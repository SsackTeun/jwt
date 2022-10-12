package com.github.ssackteun.portal.jwt.utils.token;

import java.util.Calendar;
import java.util.Date;

//Iat, Exp 생성
public class TokenWithDate {

	private static Calendar calendar;
	private static Date date;

	public static Date createOfExp(int constantOfCalendar, int i){
		calendar = Calendar.getInstance(); //캘린더 인스턴스 생성
		calendar.setTimeInMillis(calendar.getTimeInMillis()); //현재시간을 밀리세컨즈로 초기화
		calendar.add(constantOfCalendar, i);
		return calendar.getTime();
	}
}
