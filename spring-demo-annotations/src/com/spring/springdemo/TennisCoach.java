package com.spring.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class TennisCoach implements Coach {
	
	

	private FortuneService fortuneService;
	
	public TennisCoach() {
		System.out.println("default constrctor");
	}
	@Autowired
	
	public void setFortuneService(@Qualifier("happyFortuneService") FortuneService theFortunrService) {
		System.out.println("inside setFortuneService() method ");
		fortuneService=theFortunrService;
	}
	
	/*	
  
	@Autowired
	public TennisCoach(FortuneService theFortuneService) {
		fortuneService =theFortuneService;
	}
	*/
	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
