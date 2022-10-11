package com.spring.springdemo;

import org.springframework.stereotype.Component;

@Component
public class FunnyFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		// TODO Auto-generated method stub
		return  "Today is your funny day!";
	}

}
