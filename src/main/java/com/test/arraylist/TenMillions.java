package com.test.arraylist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Try with too many entries
 * @author kamoorr
 *
 */
public class TenMillions {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//10 million Array 7990
		//1 million get 225
		
		//1 million ll 412
		
		
		//array:
		//1 mil   322 ms
		
		// HashMap  i million 1007 

		long time = System.currentTimeMillis();
		Map<String, String> example = new HashMap<String, String>();
		
		int i = 0;
		for(; i<10000000; i++){
			//example.add(String.valueOf(i));
			String val = String.valueOf(i);
			example.put(val, val);
			
		}
		
		System.out.println(System.currentTimeMillis() - time);
		
		

	}

}
