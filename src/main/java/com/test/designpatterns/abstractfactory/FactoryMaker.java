package com.test.designpatterns.abstractfactory;


/**
 * Abstract factory simplify factory method pattern when there are many implementations of an interface. 
 * @author kamoorr
 *
 */

public class FactoryMaker {
	
	
	static AbstractFactory concreteFactory1;
	
	static AbstractFactory concreteFactory2;
	
	static{
		concreteFactory1 = new ConcreteFactory1();
		concreteFactory2 = new ConcreteFactory2();
	}

	public static AbstractFactory factoryMaker(boolean isToyCarFactory){
		if(isToyCarFactory){
			return  concreteFactory1;
		}else{
			return concreteFactory2;
		}
	}
	
	
	
	public static void main(String ar[]){
		FactoryMaker.factoryMaker(true).createProduct().run();
	}

}
