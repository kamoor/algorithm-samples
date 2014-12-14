package com.test.designpatterns.plugins;

/**
 * This is the one you can implement in a custom project and try to load on the fly
 * @author kamoorr
 *
 */
public interface HelloInterface {

	 public String sayHello(String input);
	 
	 public String getProviderName();
	 
}
