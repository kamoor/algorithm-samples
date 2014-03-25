package com.test.designpatterns.iterator;

import com.test.designpatterns.iterator.List.ListIterator;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String []input = {"1","2","3","4"};
		List<String> list = new List<>(input);
		Iterator<String> iter = list.getIterator();
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
	}

}
