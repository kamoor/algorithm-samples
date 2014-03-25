package com.test.operators;

public class IsPowerOf2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a =7;
		///000111
		///111000 & 00000001  == 0
		//
		
		//000100
		//111011& 00000001 = 1
		//
		
		if((~a &1) == 1){
			System.out.println("yes power of 2");
		}else{
			System.out.println("no");
		}
		
	}

}
