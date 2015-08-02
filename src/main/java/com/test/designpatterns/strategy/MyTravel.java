package com.test.designpatterns.strategy;

/**
 * Strategy Pattern
 * @author kamoorr
 *
 */
public class MyTravel {

	public static void main(String agrgs[]){
		User ratheesh = new User();
		ratheesh.setTravelStrategy(new FlyStrategy());
		
		System.out.println("Ratheesh's Travel Info: ");
		System.out.println(ratheesh.getTravelStrategy().printMethod());
		System.out.println(ratheesh.getTravelStrategy().getCost());
		
		User sam = new User();
		sam.setTravelStrategy(new RoadTravelStrategy());
		
		System.out.println("Sam's Travel Info: ");
		System.out.println(sam.getTravelStrategy().printMethod());
		System.out.println(sam.getTravelStrategy().getCost());
		
	}
}
