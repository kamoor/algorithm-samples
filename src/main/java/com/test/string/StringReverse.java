package com.test.string;

public class StringReverse {

	
	/**
	 * Will not handle surrogate pairs
	 * @param str
	 * @return
	 */
	public String reverseString(String str) {

		if (str == null){
			return str;
		}
		char[] strArray = str.toCharArray();

		int length = str.length();
		int i = length>>1;//4
		for(i=i-1;i>=0;i--){
			char temp = strArray[i];
			strArray[i] = strArray[length-(i+1)];
			strArray[length-(i+1)] = temp;
		}
		
		
		return String.valueOf(strArray);

	}
	
	
	
	public String reverseWords(String str){
		StringBuffer output = new StringBuffer();
		String[] words = str.split("[ ]");
		for(String word:words){
			output.append(this.reverseString(word));
			output.append(" ");
		}
		
		return output.toString();
		
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new StringReverse().reverseString("test1234"));
		System.out.println(new StringReverse().reverseString("test123"));
		System.out.println(new StringReverse().reverseString("Java puzzle for fun"));
        System.out.println(new StringReverse().reverseWords("Java puzzle for fun"));
	}

}
