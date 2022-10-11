package com.spring.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnatationBeanScopeDemoApp {

	public static void main(String[] args) {
		// load spring config file
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		//retrieve bean from spring conteiner
		
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		Coach alphaCoach = context.getBean("tennisCoach", Coach.class);
		
		//check if they are the same
		
		boolean result = (theCoach==alphaCoach);
		System.out.println("\nPointing to the some object :"+ result);
		
		System.out.println("\nMemory location for the theCoach:"+ theCoach);
		System.out.println("\nMemory location for the alphaCoach :"+ alphaCoach);
	
		context.close();
	}

}
