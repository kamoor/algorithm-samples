package com.test.designpatterns.abstractfactory;


public class FactoryMaker {

	public static AbstractFactory factoryMaker(boolean isToyCarFactory){
		if(isToyCarFactory){
			return  new ConcreteFactory1();
		}else{
			return new ConcreteFactory2();
		}
	}
	
	
	
	public static void main(String ar[]){
		FactoryMaker.factoryMaker(true).createProduct().run();
	}

}
