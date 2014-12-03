package com.test.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;


/**
 * Simple graph example
 * @author kamoorr
 *
 * @param <X>
 */
public class Graph<X> {

	Node<X>[] table = new Node[100];

	int size = 0;

	private class Node<X> {

		Node(X x) {
			this.data = x;
		}

		X data;
		boolean visited = false;
		List<Node<X>> neighbors = new ArrayList<Node<X>>();
	}

	public Node<X> find(X data) {
		for (int i = 0; i < size; i++) {
			if (table[i].data.equals(data)) {
				return table[i];
			}
		}
		return null;
	}

	public boolean add(X data) throws GraphException {

		
		Node<X> current = this.find(data);
		if (current != null) {
			throw new GraphException("Vertex already exists");
		}

		Node<X> newNode = new Node<X>(data);
		table[size++] = newNode;
		return true;

	}
	
	public boolean add(X[] dataArray)throws GraphException{
		for(int i=0; i<dataArray.length;i++){
			this.add(dataArray[i]);
		}
		return true;
	}

	public boolean addVertex(X oneSideD, X otherSideD)throws GraphException{
		Node<X> oneSide = this.find(oneSideD);
		Node<X> otherSide = this.find(otherSideD);
		
		if(oneSide == null || otherSide == null){
			throw new GraphException("Vertex not found");
		}
		oneSide.neighbors.add(otherSide);
		otherSide.neighbors.add(oneSide);
		return true;
	}
	
	
	public void bfs(X startFrom){
		
		Node<X> startV = this.find(startFrom);
		Queue<Node<X>> queue = new LinkedList<Node<X>>();
		
		queue.add(startV);
		printNode(startV);
		startV.visited = true;
		
		while(!queue.isEmpty()) {
			Node node = (Node)queue.remove();
			Node child=null;
			while((child=getUnvisitedChildNode(node))!=null) {
				child.visited=true;
				printNode(child);
				queue.add(child);
			}
		}
		
		
	}
	
	

	
public void dfs2(Stack<Node<X>> stack, Node<X> node){
		
		node.visited = true;
		printNode(node);
		Node<X> neighbor =null;
		while((neighbor = this.getUnvisitedChildNode(node)) !=null){
			neighbor.visited = true;
			stack.push(neighbor);
		}
		
		if(stack.isEmpty())
			return;
		dfs2(stack, stack.pop());
	}
	
	
	
	private Node<X> getUnvisitedChildNode(Node<X> node){
		for(Node<X> n: node.neighbors){
			if(n.visited == false){
				return n;
			}
		}
		return null;
	}
	
	void printNode(Node<X> node){
		System.out.println(node.data);
	}
	
	
	
	public static void  main(String args[])throws GraphException{
		Graph<String> g = new Graph<String>();
		
		String[] arr = {"A","B","C","D","E","F","G","H"};
		g.add(arr);
		
		g.addVertex("A","B");
		g.addVertex("A","G");
		g.addVertex("A","D");
		g.addVertex("E","G");
		g.addVertex("E","B");
		g.addVertex("F","B");
		g.addVertex("F","C");
		g.addVertex("F","D");
		g.addVertex("C","H");
		g.dfs2(new Stack(), g.find("A"));  
		//A
		//B
		//G
		//D
		//E
		//F
		//C
		//H
		
		
		
	}
	

}
