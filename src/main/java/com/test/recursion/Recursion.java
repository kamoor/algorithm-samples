package com.test.recursion;

import java.util.Timer;

public class Recursion {

	
	/**
	 * Multiplication using recursion
	 * @param i
	 * @param j
	 * @return
	 */
	public static int multiplyRec(int i, int j){
		if(j == 1){
			return i;
		}else{
			return i + multiplyRec(i, j-1);
		}
		
	}
	
	/**
	 * Multiplication using iteration
	 * @param i
	 * @param j
	 * @return
	 */
	public static int multiplyIter(int i, int j){
		
		int sum = 0;
		for(int k = 1;k<=j;k++){
			sum+=i;
			
		}
		return sum;
		
	}
	
	
	public static int factorialRec(int i){
		if(i <=1)
			 return i;
		else
			return i + factorialRec(i-1);
	}
	
	public static int factorialIter(int i){
		int sum = 0;
		for(int temp = i ;temp>0;temp--){
			sum+=temp ;
		}
		return sum;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long timeNow = System.nanoTime();
		System.out.println(multiplyIter(57878,5000));
		System.out.println("Delay Itr:" + (System.nanoTime() - timeNow));
		
		timeNow = System.nanoTime();
		System.out.println(multiplyRec(57878,5000));
		System.out.println("Delay Rec:" + (System.nanoTime() - timeNow));
		
		
		//Factorial comparison
		timeNow = System.nanoTime();
		System.out.println(factorialRec(5000));
		System.out.println("Delay Rec:" + (System.nanoTime() - timeNow));
		
		
		timeNow = System.nanoTime();
		System.out.println(factorialIter(5000));
		System.out.println("Delay Itr:" + (System.nanoTime() - timeNow));
		
		
	}

}
