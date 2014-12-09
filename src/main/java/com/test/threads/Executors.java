package com.test.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class Executors {
	
	
	public void execute(List<String> list) throws InterruptedException{
		
		for(String str: list){
			ExecutorService executorService = java.util.concurrent.Executors.newSingleThreadExecutor();
	        executorService.submit(new Thread(new T(str)));
            executorService.shutdown();
            executorService.awaitTermination(Integer.MAX_VALUE, TimeUnit.SECONDS);
     	}
	}
	
	
	public static void main(String args[]) throws InterruptedException{

		List<String> list = new ArrayList<String>();
		list.add("t1");
		list.add("t2");
		list.add("t3");
		list.add("t4");
		list.add("t5");
		list.add("t6");
		list.add("t7");
		list.add("t8");
		list.add("t9");
		new Executors().execute(list);
	}
}
	
class T implements Runnable{
		
		String str ;
		T(String str){
				this.str = str;
		}
	
		public void run() {
			System.out.println("hello "+ str);		
			try{
				Thread.sleep(3000);
			}catch(Exception e){
				
			}
		}
    	
}
