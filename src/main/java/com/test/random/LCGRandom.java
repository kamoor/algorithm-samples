package com.test.random;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * http://en.wikipedia.org/wiki/Linear_congruential_generator
 * LCG random number generator
 * longer m, better random
 * @author kamoorr
 *
 */
public class LCGRandom {
	
	//X_{n+1} = \left( a X_n + c \right)~~\bmod~~m
	
	long m = 912214900;
	long c = 10;
	int a  = 7867777;
	long current;
	
	public LCGRandom() {
		current = 10;
	}
	
	public long random(){
		current =((a*current) + c) % m;
		return current;
	}
	
	public static void main(String args[]){
		LCGRandom r = new LCGRandom();
		Set<Long> numbers = new HashSet<Long>();
		int i=0;
 		for(;i<2000000;i++)
		{
			numbers.add(r.random());
			System.out.println("Random "+ r.random());
		}
 		System.out.println("Random Repeated "+ ( i - numbers.size()));

	}

}
