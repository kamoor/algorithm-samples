package com.test.fun;

public class Series {

	//A, B ...Z AA, AB ... ZZ
	public String nthOfExcelCol(int n){
		//26
		int remainder = n%26;
		int div = n/26;
		if(div > 0)
		System.out.print(Character.toChars(64+div));
		//if(remainder < )
		System.out.print(Character.toChars(65+remainder));
		
		return "";
				
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for(int i=0; i<800; i++){
		new Series().nthOfExcelCol(i);
		System.out.println("\n");}

	}

}
