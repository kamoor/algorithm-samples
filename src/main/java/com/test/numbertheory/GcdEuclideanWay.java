package com.test.numbertheory;

/**
 * Find Greatest Common divisor by Euclidean theory
 * http://en.wikipedia.org/wiki/Euclidean_algorithm
 * @author kamoorr
 *
 */
public class GcdEuclideanWay {

	
	/**
	 * Eclidian non recursive way
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
	
	/**
	 * Recursive way of implementing euclidian algorithm
	 * @param x
	 * @param y
	 */
	private int findGcdRecursive(int x, int y){
		
			if(y == 0){
				return x;
			}else{
				return findGcdRecursive(y, x%y);
			}
	}
	
	
	public static void main(String[] args) {
		System.out.println( new GcdEuclideanWay().findGcd(1785,  546));
		System.out.println( new GcdEuclideanWay().findGcd(99,  78));
		System.out.println( new GcdEuclideanWay().findGcd(30,  24));
		
		System.out.println( new GcdEuclideanWay().findGcdRecursive(1785,  546));
	}

}
