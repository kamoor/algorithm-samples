package com.test.hashmap;

import java.util.HashMap;
import java.util.Map;

public class TestMyHashCode {
	
	public static void main(String args[]){
		
		MyString m1 = new MyString("ratheesh");
		MyString m2 = new MyString("rachana");
		System.out.println(m1.equals(m2));
		
		Map<MyString, String> testMap = new HashMap<MyString, String>();
		testMap.put(m1, "age=30");
		testMap.put(m2,  "age=28");
		System.out.println(testMap.get(m1));
		System.out.println(testMap.get(m2));
 	}

}
