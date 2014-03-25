package com.test.fun;

public class FindLongestDuplicateSubString {
	
	
	/**
	 * Find largest substring which duplicate more than once
	 * @return
	 */
	public String findLongestDuplicateSubString(String str){
		
		String output = "";
		
		if(str == null )
			return output;
		
		int length = str.length();
		
		if(length ==1 )
			return output;
		
		//ABCDEF2323ABCDsdfdsfABCDEFG
		for(int i=0; i<length; i++){
			StringBuffer buffer = new StringBuffer("");
			for(int j= i+1; j<length; j++){
				
				if(str.charAt(i) == str.charAt(j)){
					//move i and j together from here onwards and find substring
					int iTemp = i;
					while(str.charAt(iTemp) == str.charAt(j)){
						buffer.append(str.charAt(iTemp)); 
						iTemp++;
						j++;
						if(j == length){
							break;
						}
					}
					if(output.length() < buffer.length()){
						output = buffer.toString();
					}
					buffer.setLength(0);
				}
				
				
			}
		}
		return output;
		
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FindLongestDuplicateSubString check = new FindLongestDuplicateSubString();
		System.out.println(check.findLongestDuplicateSubString("ABCDABCCABCDCBEDEDEDE3432432DEDEDE"));

	}

}
