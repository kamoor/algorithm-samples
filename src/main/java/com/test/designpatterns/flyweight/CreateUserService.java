package com.test.designpatterns.flyweight;

import com.test.designpatterns.flyweight.FlyWeight.ServiceE;

public class CreateUserService implements FlyWeight {

	public CreateUserService() {
		FlyWeightFactory.register(ServiceE.CREATE_USER, this);
	}

	@Override
	public FlyWeight getService(ServiceE serviceType) {
		return new CreateUserService();
	}

	public String getServiceURL() {
		return "THis is Create User Service";
	}

}
