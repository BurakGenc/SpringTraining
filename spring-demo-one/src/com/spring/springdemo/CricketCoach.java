package com.spring.springdemo;

public class CricketCoach implements Coach {
	private FortuneService fortuneService;
	
	
	private String emailAddress;
	private String team;
	
	
	public String getEmailAddress() {
		return emailAddress;
	}



	public void setEmailAddress(String emailAddress) {
		System.out.println("inside setter criktet coach - setEmailAddress");
		this.emailAddress = emailAddress;
	}



	public String getTeam() {
		return team;
	}



	public void setTeam(String team) {
		System.out.println("inside setter criktet coach - setTeam");
		this.team = team;
	}



public CricketCoach() {	
	System.out.println("inside no arg consturctor criktet coach - setFortuneService");}

	
	
	public void setFortuneService(FortuneService fortuneService) {
		
		System.out.println("inside setter criktet coach - setFortuneService");
	this.fortuneService = fortuneService;
}


	
	

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Practice fast bowling for 15 minutes";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
