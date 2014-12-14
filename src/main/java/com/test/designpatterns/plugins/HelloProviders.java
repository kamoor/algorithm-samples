package com.test.designpatterns.plugins;

import java.util.HashMap;
import java.util.Map;

public class HelloProviders {
	
	private static Map<String, HelloInterface> helloProviders;
	 
	static{
		 helloProviders = new HashMap<String, HelloInterface>();
		 addProvider(new HelloImplDefault());
	 }
	 
	 
	 public static void addProvider(HelloInterface helloImpl){
		 helloProviders.put(helloImpl.getProviderName(), helloImpl);
	 }
	 
	 public static  Map<String, HelloInterface> getProviders(){
		 return helloProviders;
	 }
	 
	 public static void  sayHelloFromAll(){
		 for(String provider: helloProviders.keySet()){
			 HelloInterface hello =  helloProviders.get(provider);
				System.out.println(hello.getProviderName() + " says "+ hello.sayHello(null));
		 }
	 }
	 

}
