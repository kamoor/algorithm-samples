package com.test.operators;

public class BitFindOppositSign {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a = -10;
		int b = 12;
		
		//represent binary int mask = Integer.parseInt("1000000000000000",2);
		if((a^b)<0)
			System.out.println("opposite sign");
		else
			System.out.println("same sign");
		//if((a & b) & 0xF)

	}

}
