package com.test.sort;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Bubble Sort example
 * @author MIBRLK0
 *
 */
public class BubbleSort {
	
	
	private int[] sort(int[] input){
		
		if(input == null)
			return input;
		
		int length = input.length;
		
		if(length < 2)
			return input;
		
		for(int i=0;i<length;i++){
			for(int j = i+1; j<length;j++){
				if(input[i] > input[j]){
					int temp = input[i];
					input[i] = input[j];
					input[j] = temp;
					
				}
			}
		}
		
		return input;
		
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	int[] input = {1,4,10,0,2,3,4,10,34,23};
	int[] output = new BubbleSort().sort(input);
	System.out.println(Arrays.toString(output));

	}

}
