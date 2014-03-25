package com.test.designpatterns.pool;

import java.util.concurrent.Semaphore;

public class MyPool {

	private static int  MAX_CAPACITY = 10;
	private Semaphore availability = new Semaphore(MAX_CAPACITY, true);
	boolean objectTracker[] = new boolean[MAX_CAPACITY];
	Connection[] connections = new Connection[MAX_CAPACITY];
	
	
	public MyPool(){
		for(int i=0;i<MAX_CAPACITY;i++){
			connections[i] = new Connection("Connection #"+ i);
		}
	}
	
	
	
	public Connection getObject() throws InterruptedException{
		availability.acquire();
		return findOne();
	}
	
	
	
	private synchronized Connection findOne(){
		for(int i=0;i<MAX_CAPACITY;i++){
			if(objectTracker[i] == false){
				objectTracker[i]= true;
				return connections[i];
			}
		}
		return null; // never reach here 
		
	}
	
	//putit back should have available.release();
	
	
	class Connection{
		String name;
		
		public Connection(String name){
			this.name = name;
		}
		public String getName(){
			return name;
		}
		
		public void setName(String n){
			this.name = n;
		}
	}
	
}
