package com.spring.running;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.aop.User;

public class LoginTest {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("login.xml");
		
		User user = context.getBean("user", User.class);
		
		try {
			user.login("admin");
			user.login("용기님");
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

}
