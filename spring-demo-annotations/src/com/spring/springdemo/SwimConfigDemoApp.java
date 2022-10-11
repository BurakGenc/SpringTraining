package com.spring.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SwimConfigDemoApp {

	public static void main(String[] args) {
		//read spring config file
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		
		
		// bean from spring container 
		
		SwimCoach theCoach = context.getBean("swimCoach",SwimCoach.class);
				
			
		// call method on the bean
		
				System.out.println(theCoach.getDailyWorkout());
				
		//call method to the get fortune	
				System.out.println(theCoach.getDailyFortune());
				
				System.out.println(theCoach.getEmail());
				
		// close the context
		context.close();
	}

}
