package com.test.sort;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class RadixSort {
	
	private int findmax(int a[]){
		int max = a[0];
		for(int i:a){
			max = Math.max(i, max);
		}
		System.out.println(max);
		
	return max;
	}
	
	//complexity O(kN)
	public int[] sort(int[] numbers){
		
		@SuppressWarnings("unchecked")
		List<Integer> []buffer = new ArrayList[10];;
		
		//maximum number
		int biggestNumber = this.findmax(numbers);
		int length = numbers.length;
		//find how many digitas it has
		//int maxDigitas = (int)(Math.log10(biggestNumber)+1);
		
		//start from 10, then 100, then 1000 so on
		for(int mod=10; mod<=biggestNumber *10; mod= mod*10){
			System.out.println("Mod Factor: "+ mod);
			
				//create or clear temp buckets
				for(int index =0; index<10; index++){
					if(mod ==10){
						buffer[index] = new ArrayList<Integer>();
					}else{
						buffer[index].clear();
					}
				}
				//Now go through input and put them in bucket
				for(int j=0;j<length; j++){
					//find mod
					int jMod = numbers[j]%mod;
					//then divide by mod/10
					int bucket = jMod/(mod /10);
					buffer[bucket].add(Integer.valueOf(numbers[j]));
				}
				//Now push it back to original array in the order of bit asc order
				int i=0;
				for(List<Integer> eachList: buffer){
					
					for(Integer temp: eachList){
						numbers[i++] = temp.intValue();
					}
				}
			
		}
		//after LSB to MSB we got the number ..
		
		return numbers;
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int []input= {10, 3, 44, 101, 4390, 156, 100};
		int []output = new RadixSort().sort(input);
		System.out.println(Arrays.toString(output));

	}

}
