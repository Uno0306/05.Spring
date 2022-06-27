package com.spring.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import step01.model.domain.Car;
import step01.model.domain.People;

public class Step02Test {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("step02.xml");
		
		// step01
		// People
		People p1 = context.getBean("p1", People.class);
		System.out.println(p1);
		
	}

}
