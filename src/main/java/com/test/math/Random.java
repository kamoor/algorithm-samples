package com.test.math;

public class Random {
	
	 static long seed = 111L;

	 public static long random(){
		 String temp = String.valueOf(seed * seed);
		 seed = Long.parseLong(temp.substring(1, temp.length()));
		 return seed;
	 }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for(int i=0;i<1000;i++){
			System.out.println(Random.random());
		}

	}

}
