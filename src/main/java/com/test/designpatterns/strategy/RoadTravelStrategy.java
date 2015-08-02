package com.test.designpatterns.strategy;

public class RoadTravelStrategy implements TravelStrategy{

	public String printMethod() {
		return "By Road";
	}

	public double getCost() {
		return 800;
	}

	
}
