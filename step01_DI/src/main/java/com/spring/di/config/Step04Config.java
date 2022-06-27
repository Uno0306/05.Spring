package com.spring.di.config;

//import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//import step03.model.domain.People;
//import step03.model.domain.Car;

@Configuration
@ComponentScan(basePackages = {"step03.model.domain"})
public class Step04Config {
	
//	@Bean
//	public Car car() {
//		Car car = new Car();
//		return car;
//	}
//	
//	@Bean
//	public People people(Car car) {
//		People people = new People();
//		people.setMyCar(car);
//		return people;
//	}
	
}
