package com.test.designpatterns.factory;

public class ToyCar implements IProduct {

	
	String name;
	
	@Override
	public String run() {
		return "I am not real device, I am just a toy";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

}
