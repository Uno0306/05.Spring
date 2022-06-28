package com.spring.common;

public class LoginNoticeAspect {
	
	// 로그인 성공 시 실행되는 공통 로직
	public void noticeLoginUser(Object name) {
		if(name != null) {
			System.out.println(name + "님 환영합니다.");
		}
	}
	
	// 로그인 실패 시 실행되는 공통 로직
	public void noticeLoginException(Exception exception) {
		System.out.println("발생된 문제 : " + exception.getMessage());
	}
}
