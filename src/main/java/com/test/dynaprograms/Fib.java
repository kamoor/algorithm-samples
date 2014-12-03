package com.test.dynaprograms;

public class Fib {
	
	 static int[] cache;
	
	public static int fib(int n){
		if(n<2)
				return 1;
		else{
			
			cache[n] =(cache[n-1] > 0?cache[n-1]: fib(n-1))+ ((cache[n-2] > 0?cache[n-2]: fib(n-2)));
			
			return cache[n];
			//return fib(n-1) + fib(n-2);
			
		}
	}

	public static void main(String[] args) {
	
		long t1 = System.currentTimeMillis();
		int num = 100; //57694
		cache = new int[num+1];
		
		System.out.println(fib(num));
		System.out.println(System.currentTimeMillis() -t1);
		
	}

}
