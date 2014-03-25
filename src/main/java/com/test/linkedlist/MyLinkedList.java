package com.test.linkedlist;

import java.util.LinkedList;
import java.util.List;

import javax.swing.text.Position;

import com.test.linkedlist.ReverseLinkedList.Node;

/**
 * Custom linked list in java
 * add Node, search through nodes etc 
 * @author Ratheesh Kamoor
 *
 * @param <X>
 */
public class MyLinkedList<X> {

	private static class Node<X>{
		X data;
		Node<X> next;
		Node<X> prev;
		int position;
	}
	
	Node<X> head;
	Node<X> tail;
	int size;
	
	public MyLinkedList(){
		
	}
	
	public void print(){
		if(head == null){
			return;
		}
		Node<X> temp = head;
		while(temp != null){
			System.out.println(temp.data);
			temp = temp.next;
		}
	}
	
	public boolean add(X item){
		
		if(head == null){
			head = new Node<X>();
			head.data = item;
			tail = head;
		}else{
			
			Node<X> newOne = new Node<X>();
			
			newOne.data = item;
			newOne.position = size;
			tail.next = newOne;
			newOne.prev = tail;
			tail = newOne;
			
		}
		size++;
		return true;
	}
	
	private X findReverse(int i){
		Node<X> temp = tail;
		while(i < temp.position){
			temp = temp.prev;
		}
		return temp.data;
	}
	
	private X findForward(int i){
		Node<X> temp = head;
		while(i > temp.position){
			temp = temp.next;
		}
		return temp.data;
	}
	
	public X get(int i){
		
		if(i < (size >> 2)){
			return findForward(i);
		}else{
			return findReverse(i);
		}
	} 
	
	public void reverseRecursive(){
		
	}
	
	private Node<X> reverse(Node<X> node){
		node.next = reverse(node.next);
		return null;
	}
	
	public void reverseNoRecursive(){
		
		if(head == null || head.next == null){
			return;
		}
		
		Node<X> current = head.next;
		Node<X> prev = head;
		while(current != null){
			Node<X> next = current.next;
			current.next = prev;
			if(next == null){
				head.next = null;
				head = current;
				return;
			}
			prev = current;
			current = next;
		
			
			
			
		
		}
		
		
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		MyLinkedList<Integer> l =  new MyLinkedList<Integer>();
		
		///test reverse
		for(int k=1;k<=10;k++){
			l.add(new Integer(k));
		}
		l.print();
		System.out.println("---------------");
		l.reverseNoRecursive();
		l.print();
		System.out.println("---------------");
		//test performace
		
		
		long t = System.currentTimeMillis();
		for(int i= 0 ; i<100000; i++){
			l.add(new Integer(i));
		}
		System.out.println("My LL time = "+ ( System.currentTimeMillis() - t));
		
		t = System.currentTimeMillis();
		for(int i= 0 ; i<100000; i++){
			l.get(i);
		}
		System.out.println(l.get(5000).toString());
		System.out.println("My LL read time = "+ ( System.currentTimeMillis() - t));
		
		
		List<Integer> l1 = new LinkedList<Integer>();
		t = System.currentTimeMillis();
		for(int i= 0 ; i<100000; i++){
			l1.add(new Integer(i));
		}
		System.out.println("Java LL time = "+ ( System.currentTimeMillis() - t));
		
		
		t = System.currentTimeMillis();
		for(int i= 0 ; i<100000; i++){
			l1.get(i);
		}
		System.out.println("java read time = "+ ( System.currentTimeMillis() - t));
		
	

		
	}

}
