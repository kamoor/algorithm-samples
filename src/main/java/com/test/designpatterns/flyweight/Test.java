package com.test.designpatterns.flyweight;

import com.test.designpatterns.flyweight.FlyWeight.ServiceE;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//this is just dummy instead of spring wiring 
		new FindService();
		new CreateUserService();
		
		
		System.out.println(FlyWeightFactory.getService(ServiceE.CREATE_USER).getServiceURL());
		System.out.println(FlyWeightFactory.getService(ServiceE.FIND_USER).getServiceURL());

	}

}
