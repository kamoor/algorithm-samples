package com.test.designpatterns.abstractfactory;

import com.test.designpatterns.factory.IProduct;
import com.test.designpatterns.factory.RealCar;
import com.test.designpatterns.factory.ToyCar;

public class ConcreteFactory1 extends AbstractFactory {

	@Override
	public IProduct createProduct() {
		IProduct car = new RealCar();
		car.setName("Real Car");
	    return car;
	}

	

}
