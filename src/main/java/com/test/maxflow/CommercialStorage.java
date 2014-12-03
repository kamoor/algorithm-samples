package com.test.maxflow;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 
 * 
 * This will find a possible commercials schedule with 10 slots and 26 commercials.
 * This one use MaxFlow prblem solution by Edmond Karp alogorith 
 * 
 * http://en.wikipedia.org/wiki/Edmonds%E2%80%93Karp_algorithm
 * 
 * There are 10 commercial spot [0…9]. There are only 26 commercials approved to be run during the show, which we will label [a…z]. 
 * Since some of the commercials are for products sold by chains, it is possible
 * that there will be more one request to run the same commercial. Each request for a commercial
 * comes with the time slots when it is allowed to run. Given a set of requests determine if a schedule
 * can be found and if so display it
 * 
 * 3 >> number of commercials 
 * b 4 5 0 1 2 3 4  >> commercial#, # of people want to air, number of slots, and each slot index after that
 * f 1 1 5
 * p 4 5 5 6 7 8 9
 * 3
 * 8 b 4 5 0 1 2 3 4
 * f 1 1 5
 * p 5 5 5 6 7 8 9
   0 >> Done with input

 * How to Run:
 * Steps:
 * 1. Keep both CommercialStorage.java and EdmondKarp.java in same folder
 * 2. javac *.java
 * 3. java CommercialStorage
 * 4. Enter input as instructed in console.
 * @author kamoorr
 *
 */
public class CommercialStorage {

	BufferedReader reader = null;
	int graph[][];
	int numberOfCommercials;
	int numberOfSlots;
	int vertices;
	int totalPeopleCount;

	/**
	 * Initialize program with input reader and enough amount of matrix to store graph
	 * @param numberOfCommercials
	 * @param numberOfSlots
	 * @return
	 * @throws IOException
	 */
	private CommercialStorage init(int numberOfCommercials, int numberOfSlots)
			throws IOException {
		reader = new BufferedReader(new InputStreamReader(System.in));
		this.numberOfCommercials = numberOfCommercials;
		this.numberOfSlots = numberOfSlots;
		this.vertices = numberOfCommercials + numberOfSlots + 1 + 1;
		this.graph = new int[vertices][vertices];
		return this;
	}

	/**
	 * Get input from user.
	 * Create a graph (Source to commercials to slot to sink.
	 * Call EdmondKarp to find maxflow
	 * then determine schedule 
	 * @throws IOException
	 */
	private void start() throws IOException {
		int numberOfCommercials;
		// 26 commercials, 10 slots, 1 source, 1 sink

		while ((numberOfCommercials = this.getNumberOfCommericals()) > 0) {

			List<String> slotRequestList = this
					.getScheduleRequest(numberOfCommercials);
			System.out.println("Slot Request: " + slotRequestList.toString());
			
			for (String slotReq : slotRequestList) {
				String chunks[] = slotReq.split("[ ]");
				String commercial = chunks[0];
				int commercialIndex = (int) commercial.toCharArray()[0] - 97 + 1;
				int peopleCount = Integer.parseInt(chunks[1]);
				this.totalPeopleCount += peopleCount;
				int slotCount = Integer.parseInt(chunks[2]);
				// add capacity from source to commercial
				this.graph[0][commercialIndex] = peopleCount;

				for (int i = 0; i < slotCount; i++) {
					// connect commercial to slot with a weight;
					int slot = Integer.parseInt(chunks[i + 3]);
					System.out
							.println("Point from " + commercial + " slot "
									+ slot + ": Graph vertex ["
									+ commercialIndex + "-"
									+ (this.numberOfCommercials + slot + 1)
									+ "]");
					// Adding capacity to commercial to slot
					this.graph[commercialIndex][this.numberOfCommercials + slot
							+ 1] = 1;
					// add capacity to sink for the edge starting from commercial to sink
					this.graph[this.numberOfCommercials + slot + 1][this.vertices - 1] = 1;
				}

			}
			this.printGraph();
			// this.maxFlow = new MaxFlowFinder(this.vertices, this.graph);
			this.findSchedule();

		}

	}

	/**
	 * This find schedule if possible.
	 * To find schedule: We will use residual matrix and try to find a valid vertex for slot to commercial.
	 */
	private void findSchedule() {

		EdmondKarp edmondKarp = EdmondKarp.getInstance(this.graph, 0,
				this.vertices - 1);
		int maxFlow = edmondKarp.findMaxFlow();
		System.out.println("----------------------------------------");
		System.out.println("Max  flow: " + maxFlow);
		System.out.println("Total Req: " + this.totalPeopleCount);
		//if (this.totalPeopleCount > maxFlow) {
		//	System.out.println("no schedule for given input.");
		//	return;
		//}
		// Find actual schedules
		int res[][] = edmondKarp.getResidualMatrix();
		// store schedule in following array
		char[] schedule = new char[this.numberOfSlots];
		// In residual matrix check all the the valid vertices from slot to
		// commercial.
		// there are 10 slots, and 26 commercials.. just check for those and
		// print value >1
		for (int i = 1; i <= this.numberOfSlots; i++) {
			char selectedCommercial = '_';
			for (int j = 0; j < this.numberOfCommercials; j++) {
				if (res[j][26 + i] > 0) {
						selectedCommercial = (char) (97 + j - 1);
						break;
				}
			}
			schedule[i - 1] = selectedCommercial;
		}
		// Print schedule here
		System.out.println("--------SCHEDULE-----");
		for (char c : schedule) {
					System.out.print(c);
		}
		System.out.println("\n---------------------");
	}

	private void printGraph() {
		EdmondKarp.print(this.graph);
	}

	/**
	 * Find how many slot requests
	 * 
	 * @return
	 * @throws IOException
	 */
	private int getNumberOfCommericals() throws IOException {
		System.out.println("Enter number of commercial requests [1-10], 0 to exit: ");
		try {
			return Integer.parseInt(reader.readLine());
		} catch (NumberFormatException e) {
			return 0;
		}
	}

	/**
	 * Get all the commercial slot requests
	 * 
	 * @param commercials
	 * @return
	 * @throws IOException
	 */
	private List<String> getScheduleRequest(int commercials) throws IOException {
		List<String> slotRequests = new ArrayList<String>();
		while (commercials > 0) {
			System.out.println("Enter slot request[example: a 1 3 4 90]: ");
			slotRequests.add(reader.readLine());
			commercials--;
		}
		return slotRequests;
	}

	/**
	 * Code start from here
	 * @param agrgs
	 * @throws IOException
	 */
	public static void main(String agrgs[]) throws IOException {

		// System.out.println("Starting commercial storage..");
		CommercialStorage storage = new CommercialStorage().init(26, 10);
		// storage.test();
		storage.start();

	}
	

}
