package com.spring.running;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.aop.Car;
//import com.spring.aop.config.CarConfig;

public class Test {

	public static void main(String[] args) {
			
		@SuppressWarnings("resource")
//		ApplicationContext context = new ClassPathXmlApplicationContext("aop.xml");
		
		// config 생성해서 사용 됨
//		ApplicationContext context = new AnnotationConfigApplicationContext(CarConfig.class);
		
		// aop.xml에서 basepakage해줘도 기능함
		ApplicationContext context = new ClassPathXmlApplicationContext("aop.xml");
		
		Car car = context.getBean("car", Car.class);
		
		car.buy();
		car.buyMoney(2000);

		car.buyReturn();
		
		try {
			car.sellCar(500);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

