package com.test.tree;

import java.util.Comparator;

/**
 * Simple binary tree
 * @author MIBRLK0
 *
 * @param <X>
 */
public class SimpleBinaryTree<X> {

	
	/**
	 * Node representation
	 * @author MIBRLK0
	 *
	 * @param <X>
	 */
	private class Node<X> implements  Comparator<X>  {
		X data;
		Node<X> left;
		Node<X> right;
		
		Node(X data){
			this.data = data;
		}
		
		@Override
		public int compare(X o1, X o2) {
			return o1.toString().compareTo(o2.toString());
		}
		
	}
	
	Node<X> head = null;
	
	

	/**
	 * Inserting node after recursion
	 * @param data
	 * @param node
	 */
	private void insert(X data, Node<X> node){
		
		if(node.compare(node.data, data) == 0){
			return;
		}
		
		if(node.compare(node.data, data) > 0 ){
			  if(node.left == null){
					node.left = new Node<X>(data);
					return;
			  }else{
			  		insert(data, node.left);
			  }
		}else{
			
			 if(node.right == null){
				node.right = new Node<X>(data);
				return;
			 }else{
			  	insert(data, node.right);
			 }
			
		}
		
		
	}
	
	/**
	 * Add a new element in to tree
	 * @param data
	 * @return
	 */
	public boolean add(X data){
		
		if(head == null){
			head = new Node<X>(data);
		}else{
			insert(data, head);
		}
		return true;
	}
	
	
	/**
	 * middle order traversal left, data, right
	 * @param node
	 */
	private void middleOrderTraversal(Node<X> node){
		
		if(node.left != null){
			middleOrderTraversal(node.left);
		}
		System.out.println(node.data.toString());
		if(node.right != null){
			middleOrderTraversal(node.right);
		}
	}
	
	/**
	 * post order traversal
	 * left, right
	 * @param node
	 */
	private void postOrderTraversal(Node<X> node){
		
		
		if(node.left != null){
			postOrderTraversal(node.left);
		}
		
		if(node.right != null){
			postOrderTraversal(node.right);
		}
		System.out.println(node.data.toString());
		
	}
	
	/**
	 * Height from 0,1,2
	 * @param height
	 */
	public void printNodeAtHeight(int height){
		if(head == null){
			return;
		}else{
			this.traverseTillHeight(head, height, 0);
		}
		
	}
	
	
	private void traverseTillHeight(Node<X> node, int h, int i){
		if(i == h){
			System.out.println(node.data);
			return;
		}
		if(node.left != null){
			traverseTillHeight(node.left, h, i+1);
		}
		if(node.right != null){
			traverseTillHeight(node.right, h, i+1);
		}
		
	}
	
	public void sortAsc(){
		postOrderTraversal(head);
	}
	
	
	
	

}
