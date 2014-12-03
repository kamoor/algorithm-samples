package com.test.fun;

public class ExchangeIntegers {
	
	
	public static void main(String args[]){
		int a=10;
		int b=23;
				
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;
		
		System.out.println(a);
		System.out.println(b);
		
		int x=50;
		int y=60;
		
		x=x+y;  
        y=x-y;  
        x=x-y;
        
        System.out.println(x);
        System.out.println(y);
        
        
	}

}





