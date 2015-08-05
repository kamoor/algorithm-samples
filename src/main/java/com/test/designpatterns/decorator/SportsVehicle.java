package com.test.designpatterns.decorator;

public class SportsVehicle {

	Car car;

	public SportsVehicle(Car car) {
		this.car = car;
	}

	public String getName() {
		return "Sports " + car.getName();
	}

	public double getEngineSize() {
		return 2 * car.getEngineSize();
	}

}
