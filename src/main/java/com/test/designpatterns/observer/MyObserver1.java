package com.test.designpatterns.observer;

import java.util.Observable;
import java.util.Observer;

public class MyObserver1 implements Observer {

	public void update(Observable o, Object arg) {
		
		System.out.println("Got the content at observer 2: " + arg);
	}

}
