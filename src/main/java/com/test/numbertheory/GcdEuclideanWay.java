package com.test.numbertheory;

/**
 * Find Greatest Common divisor by Euclidean theory
 * http://en.wikipedia.org/wiki/Euclidean_algorithm
 * @author kamoorr
 *
 */
public class GcdEuclideanWay {

	
	/**
	 * 
	 * @param x
	 * @param y
	 */
	private int findGcd(int x, int y){
		
		int remainder = 10;
		int dividend = x>y?x:y;
		int divisor  = x>y?y:x;
		while(true){
			remainder = dividend % divisor;
			if(remainder == 0){
				return divisor;
			}
			dividend = divisor;
			divisor = remainder;
		}
	}
	public static void main(String[] args) {
		System.out.println( new GcdEuclideanWay().findGcd(1785,  546));
	}

}
