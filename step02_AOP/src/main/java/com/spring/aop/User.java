package com.spring.aop;

public class User {
	public String login(String user) throws Exception {
		String name = null; 
		
		if("test".equals(user) || "admin".equals(user)) {
			name = user;
		} else {
			throw new Exception("아이디를 확인해주세요.(입력된 아이디: " + user + ")");
		}
		return name;
	}
	
}
