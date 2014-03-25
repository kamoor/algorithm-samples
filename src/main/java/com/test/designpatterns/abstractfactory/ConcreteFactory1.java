package com.test.designpatterns.abstractfactory;

import com.test.designpatterns.factory.IProduct;
import com.test.designpatterns.factory.RealCar;

public class ConcreteFactory1 extends AbstractFactory {

	@Override
	public IProduct createProduct() {
		return new RealCar();
	}

	

}
