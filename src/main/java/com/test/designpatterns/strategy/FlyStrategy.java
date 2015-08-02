package com.test.designpatterns.strategy;



public class FlyStrategy implements TravelStrategy{

	public String printMethod() {
		return "By Air";
	}

	public double getCost() {
		return 2000;
	}

	
}
