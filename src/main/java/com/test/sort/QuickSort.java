package com.test.sort;


import java.util.*;

public class QuickSort
{
	
	/**
	 * Swap x and y data in A
	 * @param A
	 * @param x
	 * @param y
	 */
   private  void swap (int array[], int x, int y)
   {
      int temp = array[x];
      array[x] = array[y];
      array[y] = temp;
   }

   /**
   * Reorganizes the given list so all elements less than the first are 
   * before it and all greater elements are after it. 
   */                  
   private  int partition(int array[], int start, int end)
   {
      int pivot = array[start];
      while (start < end)
      {
    	 //find bigger one to move to right side
         while (array[start] < pivot) start++;
         //find smaller one to move to left side
         while (array[end] > pivot) end--;
         //now swap it
         swap (array, start, end);
      }
      return start;
   }

   /**
    * Quick sort
    * @param array
    * @param f
    * @param l
    */
   public  void quicksort(int array[], int f, int l)
   {
      if (f >= l) return;
      int pivot_index = partition(array, f, l);
      quicksort(array, f, pivot_index);
      quicksort(array, pivot_index+1, l);
   }

   // Usage: java QuickSort [integer] ...
   // All integers must be distinct
   public static void main(String argv[])
   {
       int input[] = {10,4,56,1,43,3,100};
      new QuickSort().quicksort(input, 0, input.length-1);

      for (int i=0 ; i < input.length ; i++) 
    	  System.out.print(input[i] + ", ");
      System.out.println();
   }
}