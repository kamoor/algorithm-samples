package com.test.fun;

public class AngleClock {

	
	public int angle(int hour, int min){
		//1 hr = 360/12 = 30 degrees
		
		double angleHr = 30D *(hour + min/60);
		//6 degrees in minute
		double angleMinute = 6D*min;
		
		return (int) Math.abs(angleHr - angleMinute);
		
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
