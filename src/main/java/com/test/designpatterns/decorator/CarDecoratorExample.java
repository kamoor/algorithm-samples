package com.test.designpatterns.decorator;

/**
 * A simple decorator example.
 * A car becomes sports version very quickly 
 * @author kamoorr
 *
 */
public class CarDecoratorExample {
	
	public static void main(String args[]){
		SportsVehicle sportsToyotaCar = new SportsVehicle(new ToyotaCar());
		System.out.println("Car " + sportsToyotaCar.getName());
		System.out.println(String.format("Engine size is %s ", sportsToyotaCar.getEngineSize()));
	}

}
