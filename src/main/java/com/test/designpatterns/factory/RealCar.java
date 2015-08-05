package com.test.designpatterns.factory;

public class RealCar implements IProduct {

	String name;

	public String run() {
		return "I am a real car";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;

	}

}
