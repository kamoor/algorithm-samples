package com.test.designpatterns.plugins;

/**
 * This is a custom implementation from provider china-guy
 * Note: Move this file to root of the project (remove package name) before dropping to plugin directory before loading
 * @author kamoorr
 *
 */
public class HelloImplFromChina implements HelloInterface{

	public String sayHello(String input) {
		return "你好世界";
	}

	
	public String getProviderName(){
		return "china-guy";
	}
}
