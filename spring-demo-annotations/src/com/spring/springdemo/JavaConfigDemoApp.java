package com.spring.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JavaConfigDemoApp {

	public static void main(String[] args) {
		//read spring config file
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		
		
		// bean from spring container 
		
		Coach theCoach = context.getBean("tennisCoach",Coach.class);
				
			
		// call method on the bean
		
				System.out.println(theCoach.getDailyWorkout());
				
		//call method to the get fortune	
				System.out.println(theCoach.getDailyFortune());
				
		
		// close the context
		context.close();
	}

}
