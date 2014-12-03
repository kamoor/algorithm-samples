package com.test.thread;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class SimpleScheduler {

	public static void main(String[] args) {
		
	   Calendar date = Calendar.getInstance();
	    date.set(
	      Calendar.DAY_OF_WEEK,
	      Calendar.THURSDAY
	    );
	    date.set(Calendar.HOUR, 15);
	    date.set(Calendar.MINUTE, 44);
	    date.set(Calendar.SECOND, 0);
	    date.set(Calendar.MILLISECOND, 0);
	    // Schedule to run every Sunday in midnight
	   Timer t = new Timer();
	   t.schedule(
	      new MyTask(),
	      date.getTime(),
	      1000 * 60 * 60 * 24 * 7
	    );
	    System.out.println("Scheduled");
	    
	  }

}

class MyTask extends TimerTask {

	public void run() {
		System.out.println("Generating report");
		// TODO generate report
	}
}
