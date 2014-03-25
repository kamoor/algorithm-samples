package com.test.search;

public class BinarySearch {

	
	int set[] = null;
	
	public BinarySearch(int[] seed){
		this.set = seed;
	}
	
	//3 4 6 98 100 443 532 
	
	private boolean search(int a, int start, int end){
		
		if(start > end){
			return false;
		}{
		int mid = (start + end) >> 1;
		
	    if(set[mid] < a){
			return search(a, mid+1, end);
		}else  if(set[mid] > a){
			return search(a, start, mid-1);
		}else{
			return true;
		}
	     
		}
	}
	
	public boolean contains(int e){
		return search(e, 0, set.length -1 );
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] set = {3 ,4, 6, 98, 100, 443, 532 };
		System.out.println(new BinarySearch(set).contains(7));

	}

}
