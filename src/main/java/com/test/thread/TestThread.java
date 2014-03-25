package com.test.thread;

import java.util.ArrayList;

import java.util.List;

public class TestThread implements Runnable{
	
	static List<String> list = new ArrayList<String>();
	
	int i =0;
	
	public TestThread(int i){
		this.i = i;
	}
	
	
	public void run(){
	while(i < 100000000){
		System.out.println(i++);
		list.add("var "+i);
		list.remove(0);
	}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Thread t = new Thread(new TestThread(100));
		Thread t1 = new Thread(new TestThread(100000));
		t.start();
		t1.start();

	}

}
