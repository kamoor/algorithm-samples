package com.test.maxflow;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * This is a max flow problem
 * http://en.wikipedia.org/wiki/Edmonds%E2%80%93Karp_algorithm
 * 
 * You cannot run this class by itself. This is used by other classes
 * Taking a java version of Edmonds Karp solution from 
 * http://en.wikibooks.org/wiki/Algorithm_Implementation/Graphs/Maximum_flow/Edmonds-Karp
 * Modified to return residual matrix and max flow.
 * @author kamoorr
 *
 */
public class EdmondKarp {
	
		int[][] res;
		int[][] matrix;
		int s;
		int t;
		
		private static EdmondKarp instance = new EdmondKarp();
		
		private EdmondKarp(){
			
		}
		
		/**
		 * Provide matrix, source and destination
		 * @param matrix
		 * @param s
		 * @param t
		 * @return
		 */
		public static EdmondKarp getInstance(int[][] matrix, int s, int t){
			instance.matrix = matrix;
			instance.s = s;
			instance.t = t;
			return instance;
		}
		
	
	    public  int findMaxFlow() {
	    	
	    	//Finding all neighbors
	    	int length = matrix.length;
	    	int[][] neighbors = new int[length][length];
	    	for(int i =0; i<length;i++){
	    		for(int j=0;j<length;j++){
	    			if(matrix[i][j] > 0){
	    				neighbors[i][j] = j;
	    			}
	    		}
	    	}
	    	
	        int n = matrix.length;
	        // Residual capacity from u to v is C[u][v] - F[u][v]
	        int[][] residual = new int[n][n];
	        while (true) {
	            int[] P = new int[n]; // Parent table
	            Arrays.fill(P, -1);
	            P[s] = s;
	            int[] M = new int[n]; // Capacity of path to node
	            M[s] = Integer.MAX_VALUE;
	            // BFS queue
	            Queue<Integer> Q = new LinkedList<Integer>();
	            Q.offer(s);
	            LOOP:
	            while (!Q.isEmpty()) {
	                int u = Q.poll();
	                for (int v : neighbors[u]) {
	                	if(v ==0){
	                		continue;
	                	}
	                    // There is available capacity,
	                    // and v is not seen before in search
	                    if (matrix[u][v] - residual[u][v] > 0 && P[v] == -1) {
	                        P[v] = u;
	                        M[v] = Math.min(M[u], matrix[u][v] - residual[u][v]);
	                        if (v != t)
	                            Q.offer(v);
	                        else {
	                            // Backtrack search, and write flow
	                            while (P[v] != v) {
	                                u = P[v];
	                                residual[u][v] += M[t];
	                                residual[v][u] -= M[t];
	                                v = u;
	                            }
	                            break LOOP;
	                        }
	                    }
	                }
	            }
	            if (P[t] == -1) { // We did not find a path to t
	                int sum = 0;
	                for (int x : residual[s])
	                    sum += x;
	                //print(residual);
	                this.res = residual;
	                return sum;
	            }
	        }
	    }
	    
	    
	    public int[][] getResidualMatrix(){
	    	return this.res;
	    }
	    
	    
	    public static void print(int[][] array){
	    		System.out.println("-----------------PRINTING ARRAY-----------------------------------");
	    		for(int i=0;i < array.length; i++){
	    			for(int j=0;j < array.length; j++){
	    				System.out.print(array[i][j] + " ");
	    			}
	    			System.out.print("\n");
	    			
	    		}
	    }
}
