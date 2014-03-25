package com.test.matrix;

import java.util.Arrays;

public class MatrixMultiply {
	
	
    
	
	public int[][] multiply(int a[][], int b[][])throws Exception{
		
		int aM = a.length;
		int aN = a[0].length;
		
		int bM = b.length;
		int bN = b[0].length;
		
      //  aM * aN   * bM*bN
		
		if(aN != bM){
			throw new Exception("cannot multiply");
			
		}
		int result[][] = new int[aM][bN];
		
		for(int i=0;i<aM;i++){
			for(int j=0;j<bN;j++){
				for(int k=0;k<aN;k++){
					result[i][j] += a[i][k] * b[k][j];
				}
			}
		}
		
		return result;
		
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)throws Exception {
		int a[][] = { {1,2}, {3,4}};
		int b[][] = { {4,5},{3,3}};
		//1 2    4 5
		//3 4    3 3
		int [][]result  = new MatrixMultiply().multiply(a, b);
		for(int i=0;i<result.length;i++){
			System.out.println(Arrays.toString(result[i]));
		}
		
		

	}

}
