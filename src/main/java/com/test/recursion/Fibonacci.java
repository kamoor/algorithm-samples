package com.test.recursion;

//0 1 1 2 3 5
public class Fibonacci {
	
	/**
	 * next int
	 * @param n
	 * @return
	 */
	public int nextInt(int n){
		if(n==0){
			return 0;
		}else if(n==1){
			return 1;
		}else{
			return  nextInt(n-1) + nextInt(n-2);
			
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Fibonacci fib = new Fibonacci();
		for(int i =0 ; i<10;i++){
			System.out.println(fib.nextInt(i));
		}
	}

}
