package com.test.maxcover;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.TreeMap;

/**
 * 
 * http://en.wikipedia.org/wiki/Maximum_coverage_problem
 * 
 * This program will try to find best possible way of picking antenna to maximize the coverage by removing intefering stations.
 * 
 * IMPORTANT NOTE: 
 * This program will exit in 30 seconds, no matter what, sometime with full result, sometime it may be partial or none.
 * Code is built with 30 Second clock after reading input file.
 * 
 * Input:
 * Number of antenna, and number of stations in first line, then coverage for each antenna
 * 6 8   >>  Nunber of antenna , number of stations
 * 4 0 2 6 7   >> number of stations covered by first antenna, and those station indexes 
 * 1 6  >> second antenna 
 * 3 1 2 7
 * 5 1 3 5 6 7
 * 4 1 3 4 7
 * 1 3   >> n-th antenna 
 * Approach:
 * ==========
 * 	1. Create a m*n matrix with antenna/coverage - I am using  HashMap to reduce scanning complexity. HashMap has read complexity of O(1)
 *  2. Try to find coverage for each antenna, This is not done separately , as I read input file, I create a sorted HashMap to store covergae for each antenna.
 *  3. After step #2, this antenna to coverage# will be sorted in ascending order.  stored in sortedMapByCoverage
 *  3.a. Try to pick the highest coverage antenna and keep adding new antenna-s if it improve coverage
 *  3.b.  Try this multiple times with second best and so on.. 
 *  
 *  Threads: In default code will not use threads, I have seen performance in PC-s better with no threads. You can always pass a paramter to enable multi-threading (see "How to Run")
 *  
 *  
 *  How to Run:
 *  ==========
 *   Copy this code in to any folder. then run following command 
 *   
 *   javac MaxCoverV3.java && java MaxCoverV3 will start the program with default (1) threads, 30 sec time out 
 *   
 *   Enable Threads:
 *   javac MaxCoverV3.java && java -Dthreads=5 MaxCoverV3    This way you can start the program with number of threads required
 *   javac MaxCoverV3.java && java -Dttl=90 MaxCoverV2 will allow program to run for 90 seconds TimeToLive, default is 30 seconds 
 *   
 *   Other command line paramters:
 *   
 *   -Ddebug=true  will print lot of information while running the program
 *   -Dthreads=5   will enable threading and spawn 5 threads,
 *   -Dttl=90      will increase Time To Live clock to 90 seconds, just in case if you are curious to know what happens if you allow more time
 *  
 *  Sample Result:
 *  
 *  det-kamoorr-m:java kamoorr$ javac MaxCoverV3.java && java MaxCoverV3 < ~/Desktop/hittinset-test-2.txt
 *  Please enter or pipe data: 
 *  30 sec clock started now.
 *  Finding max coverage for 512 X 1024 problem. This program will exit in 30 sec from now. Threads# 1
 *  -------------------------RESULT---------------------------------------
 *  Antenna# 4 Antenna(s): [249, 464, 383, 452]
 *  Station# 663
 *  
 *  SOME OTHER OBSERVATIONS:
 *  ========================
 *  	1. New Java 8 (Version: 1.8) runs lot faster than older versions. Try java -version to find out java version
 *  	2. Some input works faster with multiple threads but most of them works better with no threading. Please try both
 *  
 *  
 *  
 *  
 * @author kamoorr
 *
 */
public class MaxCover {

	static boolean debug = false;
	public static int antennaCount = 0;
	public static int stationCount = 0;
	static Map<Integer, Integer> antennaCoverageCountMap = new HashMap<Integer, Integer>();
	static SortedMap<Integer, List<Integer>> sortedMapByCoverage = new TreeMap<Integer, List<Integer>>(Collections.reverseOrder());
	static Map<Integer, List<Integer>> antennaToStations = new HashMap<Integer, List<Integer>>();
	//Change this number as we need. 
	public static int numberOfThreads = 1;
	public static Map<Integer, Integer> bestCoverage= new HashMap<Integer, Integer>();
	public static Map<Integer,  List<Integer>> bestAntennas= new HashMap<Integer,  List<Integer>>();
	static long timeStarted;

	/**
	 * Max cover logic starts here.
	 * @param input
	 */
	public void maxCover() {
		solveMaxCoverage();
	}

	private void solveMaxCoverage() {
		
		if(numberOfThreads >1 ){
				//Create as many threads as configured for more than one
				for (int i = 0; i < numberOfThreads; i++) {
					new Thread(new Task3(i, i)).start();
				}
				try {
					//This will make sure main program is not exiting until all other worker thread finish its job
					Thread.sleep(35*1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}else{
				//Do not create threads, this is better for lower configuration machines 
				new Task3(0, 0).run();
		}
		
	}



	
	/**
	 * Print result at last, This method may be invoked by last thread or timer(after 30 sec expiration)
	 */
	public static void printResult(){
		System.out.println("-------------------------RESULT---------------------------------------");
		if(MaxCover.bestAntennas == null){
			System.out.println("This code terribly failed to find best solution with in this time frame, try re-run. Sorry! ");
		}else{
			
			int coverage =0;
			int threadId =0;
			for(Entry<Integer, Integer> entry: MaxCover.bestCoverage.entrySet()){
				if(coverage < entry.getValue()){
					threadId = entry.getKey();
					coverage = entry.getValue();
				}
			}
			
			System.out.println("Antenna# "+ MaxCover.bestAntennas.get(threadId).size() + " Antenna(s): "+ MaxCover.bestAntennas.get(threadId));
			System.out.println("Station# " + coverage);
		}
		System.exit(0);
	}
	
	
	/**
	 * Read input, parse and create matrix
	 * @throws IOException
	 */
	private void start(int maxTimeInSec) throws IOException{
		
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Please enter or pipe data: ");
	
		//File f = new File(readerConsole.readLine());
		//BufferedReader reader = new BufferedReader(new FileReader(f));
		
		// System.out.println("Reading input file. This time is not included in "+maxTimeInSec+" sec rule.");
		
		String[] line1 = reader.readLine().split(" ");
		antennaCount = Integer.parseInt(line1[0]);
		stationCount = Integer.parseInt(line1[1]);

		for (int i = 0; i < antennaCount; i++) {
				// read eaach line
				String[] line = reader.readLine().split(" ");
				int coverageCount = Integer.parseInt(line[0]);
				// read stations for
				List<Integer> stationList = new ArrayList<Integer>();
				for (int j = 0; j < coverageCount; j++) {
					int station = Integer.parseInt(line[j + 1]);
					stationList.add(station);
					
				}
				antennaToStations.put(i,stationList);
				this.addAntennaCoverage(i, coverageCount);

		}
		System.out.println(maxTimeInSec + " sec clock started now."); 
		timeStarted = System.currentTimeMillis();
		new TimedExit3(maxTimeInSec);
		System.out.println("Finding max coverage for "+antennaCount+" X "+stationCount+ " problem. This program will exit in "+maxTimeInSec+" sec from now. Threads# "+ numberOfThreads);
		// printArray(input);
		this.maxCover();
	}
	

	/**
	 * Add coverage count for an antenna 
	 * This is using sorted hashmap
	 * @param antenna
	 * @param count
	 */
	private void addAntennaCoverage(int antenna, int count) {
		if (count == 0) {
			return;
		}
		antennaCoverageCountMap.put(antenna, count);
		// need to fix if more than one antenna has same coverage
		if (sortedMapByCoverage.containsKey(count)) {
			List<Integer> l = sortedMapByCoverage.get(count);
			l.add(antenna);
			sortedMapByCoverage.put(count, l);
		} else {
			List<Integer> l = new ArrayList<Integer>();
			l.add(antenna);
			sortedMapByCoverage.put(count, l);
		}
	}
	
	

	/**
	 * Logging debug info
	 * @param str
	 */
	public static void log(String str) {
		if (debug) {
			System.out.println(str);
		}
	}



	/**
	 * Program initialize from here.
	 * @param args
	 * @throws IOException
	 */
	public static void main(String args[]) throws IOException {
		
			int ttl = 30;
			
			/**
			 * Number of threads spawned , default 10;
			 */
			if(System.getProperty("threads") != null){
				numberOfThreads = Integer.parseInt(System.getProperty("threads").trim());
			}
			
			/**
			 * debug will print lot more information while running. 
			 */
			if(System.getProperty("debug") != null){
				debug = Boolean.parseBoolean(System.getProperty("debug").trim());
			}
			/**
			 * Time to live(ttl)
			 */
			if(System.getProperty("ttl") != null){
				ttl = Integer.parseInt(System.getProperty("ttl").trim());
			}
			
			MaxCover maxCover = new MaxCover();
			maxCover.start(ttl);


	}
	


}

/**
 * This class will allow to multi-thread processing.
 * @author kamoorr
 *
 */
class Task3 implements Runnable{
	
	int start;
	int threadId;
	static int finishedThreads =0;
	
	public Task3( int start, int threadId){
		this.start =start;
		this.threadId = threadId;
	}
	
	/**
	 * This is the way java allows to implement a new thread
	 */
	public void run(){
		
		for(int i = start;i<MaxCover.antennaCount;i = i+MaxCover.numberOfThreads){
				solveFrom(i);
		}
		markFinished();
		if(finishedThreads == MaxCover.numberOfThreads){
			MaxCover.printResult();
		}
	}
	
	/**
	 * Synchronized method to keep track if all x threds completed or not.
	 */
	private synchronized void markFinished(){
			finishedThreads++;
	}
	
	
	/**
	 * This code will try to find the max coverage starting from n-th antenna.
	 * Many threads may use this method from differen n values. 
	 * @param input
	 * @param start
	 */
	private void solveFrom( int start) {

		if (start > MaxCover.antennaCount) {
			return;
		}
		MaxCover.log("-----------------------------------------------------");
		List<Integer> chosenAntennas = new ArrayList<Integer>();
		List<Integer> coveredStations = new ArrayList<Integer>();

		// get the antenna
		int index = -1;
		for (int antennaKey : MaxCover.sortedMapByCoverage.keySet()) {
			List<Integer> antennas = MaxCover.sortedMapByCoverage.get(antennaKey);
			for (int antenna : antennas) {
				index++;
				if (index < start) {
					continue;
				}
				if (chooseIfAddedValue(antenna, chosenAntennas,coveredStations)) {
					
					int newCoverage = coveredStations.size();
					MaxCover.log("chosen antenna: " + antenna + " | Covergae# " + newCoverage);
					Integer previoudBest = MaxCover.bestCoverage.get(threadId);
					if (newCoverage > (previoudBest == null? 0: previoudBest)) {
						MaxCover.bestCoverage.put(threadId, newCoverage);
						MaxCover.bestAntennas.put(threadId, chosenAntennas);
					}
				}
				
			}

		}
		MaxCover.log("covered stations from antenna "+start +"-"+ coveredStations.toString());
	}
	

	/**
	 * Take antenna if it gives added coverage, means inteference is less than
	 * added coverage
	 * @param antenna
	 * @param input
	 * @param covered
	 * @return
	 */
	private boolean chooseIfAddedValue(int antenna, 
			List<Integer> chosenAntennas, List<Integer> coveredStations) {
		
			List<Integer> addedCoverage = new ArrayList<Integer>();
			List<Integer> removedCoverage = new ArrayList<Integer>();
			for (Integer station: MaxCover.antennaToStations.get(antenna)) {
					if (coveredStations.contains(station)) {
						removedCoverage.add(station);
					} else {
						addedCoverage.add(station);
					}
			}
			
			if (addedCoverage.size() > removedCoverage.size()) {
				chosenAntennas.add(antenna);
				coveredStations.addAll(addedCoverage);
				coveredStations.removeAll(removedCoverage);
				return true;
			} else {
				MaxCover.log("done with one more antenna");
				return false;
			}
			
	}
	

	
}

/**
 * This class will make program exit in certain time frame. Pass time in seconds
 * while creating object
 * 
 * @author kamoorr
 *
 */
class TimedExit3 {
	Timer timer = new Timer();
	TimerTask exitApp = new TimerTask() {
		public void run() {
			System.out.println("Time expired. printing partial result to meet deadline..");
			MaxCover.printResult();
		}
	};

	public TimedExit3(int seconds) {
		timer.schedule(exitApp, new Date(System.currentTimeMillis() + seconds * 1000));
	}
}
