package com.test.designpatterns.singleton;

public class SingletonStatic {
	
	String name;
	
	
	
	private static SingletonStatic object = null;
	
	private SingletonStatic(){
		
	}
	
	
	public static SingletonStatic getInstance(){
		if(object == null){
			object = new SingletonStatic();
		}
		return object;
	}
	
	
	
	
	

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SingletonStatic.getInstance().getName();

	}

}
