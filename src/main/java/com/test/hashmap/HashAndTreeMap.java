package com.test.hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class HashAndTreeMap {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		long t = System.currentTimeMillis();
		Map<String, String> hashMap = new HashMap<String, String>();
		
		
		for(int i=0; i<1000000; i++){
			hashMap.put("KEY"+i, i+"VAL");
		}
		
		System.out.println("Time for hash Map insert " + (System.currentTimeMillis() - t));
		t = System.currentTimeMillis();
		hashMap.get("KEY"+79898);
		System.out.println("Time for hash Map get " + (System.currentTimeMillis() - t));
			
		
		t = System.currentTimeMillis();
		Map<String, String> hashMap2 = new TreeMap<String, String>();
		
		for(int i=0; i<1000000; i++){
			hashMap2.put("KEY"+i, i+"VAL");
		}
		
		System.out.println("Time for tree map insert " + (System.currentTimeMillis() - t));
		t = System.currentTimeMillis();
		hashMap2.get("KEY"+79898);
		System.out.println("Time for tree Map get " + (System.currentTimeMillis() - t));

	}

}
