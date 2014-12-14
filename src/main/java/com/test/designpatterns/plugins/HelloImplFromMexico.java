package com.test.designpatterns.plugins;

/**
 * This is a custom implementation from provider mexico-guy
 * Note: Move this file to root of the project (remove package name) before dropping to plugin directory before loading
 * @author kamoorr
 *
 */
public class HelloImplFromMexico implements HelloInterface{

	public String sayHello(String input) {
		return "Hola Mundo";
	}

	
	public String getProviderName(){
		return "mexico-guy";
	}
}
