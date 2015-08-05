package com.test.designpatterns.abstractfactory;

import com.test.designpatterns.factory.IProduct;
import com.test.designpatterns.factory.ToyCar;

public class ConcreteFactory2 extends AbstractFactory{

	
	@Override
	public IProduct createProduct() {
		IProduct car = new ToyCar();
		car.setName("Toy");
	    return car;
	}

}
