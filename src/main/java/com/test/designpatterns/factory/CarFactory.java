package com.test.designpatterns.factory;


public class CarFactory {
	
	
	
	
	public static IProduct getACar(double price){
		
		if(price <1000){
			return new ToyCar();
		}else{
			return new RealCar();
		}
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IProduct car = CarFactory.getACar(50);
		System.out.println(car.run());
		
		car = CarFactory.getACar(5000);
		System.out.println(car.run());

	}

}
