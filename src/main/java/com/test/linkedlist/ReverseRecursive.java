package com.test.linkedlist;

import com.test.linkedlist.ReverseLinkedList.Node;

public class ReverseRecursive {

	public class Node{
		int data;
		Node next;
		
		public Node(int data){
			this.data = data;
		}
		
		
	}
	
	public void print(Node head){
		Node t = head;
		while(t != null ){
			System.out.println(t.data);
			t = t.next;
		}
	}
	
	Node h = null;
	
    private Node recurse(Node current, int i){
    	    if(current == null)
    	    		return null;
    	    
    	    if(current.next == null){
    	    	h = current;
    	    }
    	    
    		Node next = recurse(current.next, i+1);
    		if(next!= null){
    			next.next = current;
    			if(i==0){
    				current.next = null;
    			}
    		}
    		
    		return current;
    	
    }
	
	public void nthElementFromLast(Node head){
		Node temp =recurse(head, 0);
			 
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ReverseRecursive r = new ReverseRecursive();
		Node n1 = r.new Node(1);
		Node n2 = r.new Node(2);
		Node n3 = r.new Node(3);
		Node n4 = r.new Node(4);
		Node n5 = r.new Node(5);
		
		r.h = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		
		r.print(r.h);
		r.nthElementFromLast(n1);
		System.out.println("......................");
		r.print(r.h);
		
		//7 79 7 6 9 9 0 6 4 2 2 

	}

}
