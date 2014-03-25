package com.test.sort;

import java.util.Arrays;

public class CoutingSort {

	int maxCount;
	int[] coutingArray;
	
	public CoutingSort(int maxCount){
		this.maxCount = maxCount;
		coutingArray = new int[maxCount +1 ];
	}
	
	public int[] sort(int[] input)throws Exception{
		int length = input.length;
		for(int i=0; i<length; i++){
			if(input[i] > maxCount){
				throw new Exception();
			}
			coutingArray[input[i]]++;
			
		}
		int index =0;
		for(int i=0;i<maxCount;i++){
			for(int j=0;j<coutingArray[i];j++){
				input[index++] = i;
			}
			
		}
		return input;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		System.out.println();
		int l = 1000000;
		int []input = new int[l];
	    for(int i=1;i<l;i++){
	    	input[i] = Math.round(130* (float)Math.random());
	    }
	    long t1 = System.currentTimeMillis();
	    new CoutingSort(130).sort(input);
	    System.out.println("My Sort "+( System.currentTimeMillis() - t1));
	    
	    
	    t1 = System.currentTimeMillis();
	    Arrays.sort(input);
	    System.out.println("Java Sort "+( System.currentTimeMillis() - t1));
	   
	
	    
	    
	}

}
