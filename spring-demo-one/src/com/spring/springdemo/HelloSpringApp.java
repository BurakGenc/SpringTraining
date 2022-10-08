package com.spring.springdemo;

import javax.naming.Context;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext contex = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Coach theCoach = contex.getBean("myCoach", Coach.class);
		
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		contex.close();
		
		
	}

}
