package com.test.designpatterns.flyweight;

import java.util.HashMap;
import java.util.Map;

public class FlyWeightFactory {

	
	private static Map<FlyWeight.ServiceE, FlyWeight> objectPool = new HashMap<FlyWeight.ServiceE, FlyWeight>();
	
	public static void register(FlyWeight.ServiceE e, FlyWeight obj){
		objectPool.put(e, obj);
	}
	
	public static FlyWeight getService(FlyWeight.ServiceE serviceType){
		return objectPool.get(serviceType);
	}
	
	

}
