package com.test.operators;

public class BitWise {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("1<<31 : "+ (1<<31)); //-2147483648
		System.out.println("1<<32 : "+ (1<<32)); //1
		System.out.println("1>>32 : "+ (1>>32)); //1
		System.out.println("1>>33 : "+ (1>>33)); //1
		System.out.println("1>>31 : "+ (1>>31)); //0
		System.out.println("1>>>32 : "+ (1>>>32));
		System.out.println("1>>>33 : "+ (1>>>33));
		System.out.println("1>>>31 : "+ (1>>>31));
		System.out.println("-1<<4 : "+ (-1 << 4));
		System.out.println("-16>>4 : "+ (-16 >> 4));
		System.out.println("-16>>>4 : "+ (-16 >>> 4));
		
		System.out.println("10>>1 : "+  (10 >> 1));
		System.out.println("10<<1 : "+  (10 << 1));

		System.out.println("-2>>1 : "+ (-2 >> 1));
		System.out.println("-2>>>1 : "+ (-2 >>> 1));  // unsigned , negative bit becomes positive
		System.out.println("10>>>1 : "+ (10 >>> 1));
		
		System.out.println("10&11 : "+ (10 & 11));// bit wise and
		System.out.println("0xA11 & 0xA10 : "+ (0xA11 & 0xA10));
		
		
	}

}
