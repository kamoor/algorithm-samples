package com.test.designpatterns.prototype;

public class PrototypeUsage {

	/**
	 * Prototype will generate o
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		PrototypeBean firstBean = new PrototypeBean("First Bean");
		PrototypeBean secondBean = (PrototypeBean)firstBean.clone();
	    secondBean.getObject().setName("Ratheesh");
	    
	    System.out.println(firstBean.getObject().getName());
	    System.out.println(secondBean.getObject().getName());
		

	}

}
