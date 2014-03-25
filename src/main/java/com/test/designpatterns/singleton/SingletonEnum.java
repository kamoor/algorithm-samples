package com.test.designpatterns.singleton;

public enum SingletonEnum {
	
	INSTANCE(){
		
		@Override
		public void sayHelloAbstract(){
			System.out.println("Hello");
		}
	};
	
	//you can create abstract or non abstract methods
    public abstract void sayHelloAbstract();
    
    public void sayGoodBye(){
    	System.out.println("Good Bye");
    }
}