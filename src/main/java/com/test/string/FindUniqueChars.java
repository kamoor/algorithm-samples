package com.test.string;


//See if give chars are unique
public class FindUniqueChars {

	
	/**
	 * see if all characters are unique
	 * Assumption : Only english (ascii) or numbers
	 * @param input
	 * @return
	 */
	public boolean isUnique(char[] input){
		if(input == null)
			return true;
		
		int length = input.length;
		
		if(length == 1)
			return true;
		
		boolean[] checkerArr = new boolean[255];
		for(char c:input){
			int ascii = (int)c;
			if(checkerArr[ascii] == true){
				return false;
			}else{
				checkerArr[ascii] = true;
			}
					
			
		}
		
		return true;
		
	}
	
	
	/**
	 * Check if two strings are annagrams
	 * @param input
	 * @return
	 */
	public boolean isAnnagram(char[] input1, char[] input2){
		
		if(input1 == null || input2 == null)
			return true;
		
		int length1 = input1.length;
		int length2 = input2.length;
		
		if(length1 !=  length2)
			return false;
		
		
			
		short[] checkerArr = new short[255];
		for(char c:input1){
			int ascii = (int)c;
			checkerArr[ascii] = ++checkerArr[ascii];
		}
		
		for(char c:input2){
			int ascii = (int)c;
			checkerArr[ascii] = --checkerArr[ascii];
		}
		for(int c: checkerArr){
			if(c != 0)
				return false;
		}
		return true;
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		char[] input = {'Z','b','z','B'};
		System.out.println(new FindUniqueChars().isUnique(input));
		
		char[] input1 = {'b','Z','B','z'};
		System.out.println(new FindUniqueChars().isAnnagram(input, input1));
		
		char[] input2 = {'b','Z','B','C'};
		System.out.println(new FindUniqueChars().isAnnagram(input1, input2));
		
	}
	

}
