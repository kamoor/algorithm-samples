package com.test.designpatterns.strategy;

public class User {
	
	TravelStrategy travelStrategy;
	
	String name;
	
	int age;

	public TravelStrategy getTravelStrategy() {
		return travelStrategy;
	}

	public void setTravelStrategy(TravelStrategy travelStrategy) {
		this.travelStrategy = travelStrategy;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	

}
