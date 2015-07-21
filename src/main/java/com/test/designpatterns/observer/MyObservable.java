package com.test.designpatterns.observer;

import java.util.Observable;

public class MyObservable extends Observable{
	
	public MyObservable(){
		registerObservers();
	}
	
	public void registerObservers(){
		super.addObserver(new MyObserver1());
		super.addObserver(new MyObserver2());
	}
	
	
	/**
	 * Testing pattern
	 * @param args
	 */
	public static void main(String args[]){
		System.out.println("Starting..");
		MyObservable observable  = new MyObservable();
		//send one message to all observers
		observable.setChanged();
		observable.notifyObservers("Hello, World Stars now");
		//send one more message to all observers
		observable.setChanged();
		observable.notifyObservers("Hello, World Ends now");
		
		
	}
	

}
