package com.test.operators;

public class BitShift {

	//00000end111111start0000
	public int getWithOneAtSomePosition(int start, int end){
		int i =0xFFFFFFFF;
		int temp = i << (31-end);
		// Shift back to the lowest bits
		return temp >>> (31 - end + start);
		/**
		 * 11111111111111
		 */
		
	}
	
	//take i to j from second and put it in i
	public int replaceOneSetWithAnother(int first, int second, int start, int end){
		
		int oneBetweenIandJ = this.getWithOneAtSomePosition(start, end); // tem has all once between i and j
		int zeroBetweenIandJ = ~oneBetweenIandJ ;
		int subInt = second & oneBetweenIandJ; // & will make sure keep all bits between i and j, everythign else 0
		
		int result = (zeroBetweenIandJ & first) & subInt;
		return result;
		
	}
	
	
	
	public int replaceFirstToLast(int c){
		//In a C interview, I was asked to swap the first 4-bits of a 
		//number with the last 4 bit. (eg. 1011 1110 1111 1001 should be 1001 1110 1111 1011)

		//move 1011 to 0000 0000 0000 1011
		//move 1001 to 1001	0000 0000 0000
		//OR oper 1001 0000 0000 0000 1011
		
		//Now get 2nd and 3rd nibble
		//original & 0FF) then or with third step
		int temp =c;
		c = ((c & 0xf000) >> 12) | ((c & 0x000f) << 12);
		return c | (temp & 0x0FF0);
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new BitShift().getWithOneAtSomePosition(1, 2));
		System.out.println(~0xFFFFFFFF);
		System.out.println(new BitShift().replaceOneSetWithAnother(8,4,1,2));
	}

}
