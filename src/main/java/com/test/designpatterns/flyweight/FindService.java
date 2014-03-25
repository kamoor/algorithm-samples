package com.test.designpatterns.flyweight;


public class FindService implements FlyWeight {
	
	public FindService() {
		FlyWeightFactory.register(ServiceE.FIND_USER, this);
	}

	@Override
	public FlyWeight getService(ServiceE serviceType) {
		return new FindService();
	}

	
	public String getServiceURL(){
		return "THis is Finder Service";
	}
	

}
