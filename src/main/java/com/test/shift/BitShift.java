package com.test.shift;

public class BitShift {

	
	public static void main(String args[]){
		 
		int i=1;
		
		System.out.println(i << 0);
		System.out.println(i << 1);
		System.out.println(i << 2);
		
		System.out.println(i >> 1);
		
		System.out.println(-1 >> 1);
		System.out.println(-8 >>> 5);//0 00000......1
	}
}
