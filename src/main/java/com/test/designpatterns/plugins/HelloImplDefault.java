package com.test.designpatterns.plugins;

public class HelloImplDefault implements HelloInterface {

	public String sayHello(String input) {
			return "Hello World";
	}

	public String getProviderName() {
		return "default";
	}
	
	

}
