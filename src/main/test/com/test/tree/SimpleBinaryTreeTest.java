package com.test.tree;

import org.junit.Test;



public class SimpleBinaryTreeTest {

	@Test
	public void testTree(){
		SimpleBinaryTree<String> tree = new SimpleBinaryTree<String>();
		tree.add("T");
		tree.add("A");
		tree.add("X");
		tree.add("Z");
		tree.add("B");
		tree.add("V");
		tree.add("K");
		tree.add("J");
		tree.sortAsc();
		System.out.println("-------------------------");
		tree.printNodeAtHeight(0);
		System.out.println("-------------------------");
		tree.printNodeAtHeight(2);
		System.out.println("-------------------------");
		
		//tree.preOrderTraversal(tree.head);
		
	}

}
