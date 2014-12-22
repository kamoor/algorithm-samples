package com.test.string;

/**
 * Split a string using regular expression
 * @author kamoorr
 *
 */
public class SplitByAlphNumeric {
	
	static String regEx = "[^A-Z0-9]+|(?<=[A-Z])(?=[0-9])|(?<=[0-9])(?=[A-Z])";

	public static void main(String[] args) {
		String s ="CC23QQ21HD32";
		String[] splits = s.split(regEx);
		for(String chunk: splits){
			System.out.println(chunk);
		}
		

	}

}
