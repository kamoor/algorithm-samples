package com.test.sort;

public class DumpSleepSort implements Runnable {
	
	int data;
	public DumpSleepSort(int number){
		this.data = number;
	}
	public void run(){
		
		try{
			Thread.sleep(data);
			System.out.println(data);
		}catch(Exception e){
			
		}
		
	}
	
	
	public static void main(String args[]){
		int[] input = {10,43,2,4,11,332,11,33,0,89};
		for(int a: input){
			new Thread(new DumpSleepSort(a)).start();
		}
	}

}
