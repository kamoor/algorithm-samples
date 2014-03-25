package com.test.operators;
/*

swap alternate bits of a given number

eg: n=5 (0101)
output: 10(1010)

n=8(1000)
output:4(0100)
 */
public class BitShiftSwapAlternate {
	
	public static int swapOddEvenBits(int x) {
	    return ( ((x & 0xaaaaaaaa) >> 1) | ((x & 0x55555555) << 1) );
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new BitShiftSwapAlternate().swapOddEvenBits(5));
		System.out.println(new BitShiftSwapAlternate().swapOddEvenBits(8));

	}

}
