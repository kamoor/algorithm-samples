package com.test.linkedlist;

/**
 * Reverse a linked list
 * @author MIBRLK0
 *
 */
public class ReverseLinkedList {
	
	
	
	public class Node{
		int data;
		Node next;
		
		public Node(int data){
			this.data = data;
		}
		
		
	}
	
	/**
	 * Reverse iteratively
	 * @param head
	 * @return
	 */
	public Node reverse(Node head){
		//A->B->C->D->E
		if(head == null || head.next == null){
			return head;
		}
		
		Node prev = head;
		Node current= head.next;
		while(true){
			Node next=current.next;
			current.next = prev;
			if(next == null){
				head.next = null;
				return current;
			}else{
				prev = current;
				current = next;
			}
		}
	}
	
	
	
	
	public void print(Node head){
		Node t = head;
		while(t != null ){
			System.out.println(t.data);
			t = t.next;
		}
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ReverseLinkedList r = new ReverseLinkedList();
		Node n1 = r.new Node(1);
		Node n2 = r.new Node(2);
		Node n3 = r.new Node(3);
		Node n4 = r.new Node(4);
		Node n5 = r.new Node(5);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		
		r.print(n1);
		
		//Node newNode = r.reverse(n1);
		
		System.out.println("---------------------");
		//r.print(newNode);
		Node newNode = r.reverse(n1);
		System.out.println("---------------------");
		r.print(newNode);
		
		
	}

}
