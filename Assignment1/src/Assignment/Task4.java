package Assignment;

import java.util.*;

public class Task4 {
	
	
	//AVL TREE
	public static void AVLTASK() {
		
		AVLTree<Integer> t = new AVLTree<>( );
		long startTime, endTime;
		long totalTimeTaken=0;

		int n = 100000; 
		System.out.println("Create the AVL tree...");
		
		//AVL TREE INSERTION
		startTime = System.nanoTime();
		for (int i = 1; i <= n; i++) {
			t.insert(i);
			//t.checkBalance();
		}
		endTime = System.nanoTime();
		totalTimeTaken=(endTime-startTime);
		System.out.println("Average time to insert 100000 keys: " +totalTimeTaken/n+ " nanoseconds");
		
		totalTimeTaken=0;
	
		int c=0;
		
		//AVL SEARCH TIME
		startTime = System.nanoTime();
		for (int i = 1; i <= n; i++) {
			int Random = (int)(Math.random()*100000);
			if (t.contains(Random))
				c=c+1;
				
		}
		endTime = System.nanoTime();
		
		//System.out.println(c+"keys found");
		
		totalTimeTaken=(endTime-startTime);
		System.out.println("Average time for searching 100000 random strings: " + totalTimeTaken/n + " nanoseconds");
		
		//AVL DELETION
		totalTimeTaken=0;

		startTime = System.nanoTime();
		for (int i = n; i >= 1; i--) {
			t.remove(i);
			//t.checkBalance();
		}
		endTime = System.nanoTime();
		totalTimeTaken=(endTime-startTime);
		System.out.println("Average time to delete 100000 keys: " + totalTimeTaken/n + " nanoseconds");

		//System.out.println("Tree after removals:");
		//t.printTree();
	}
public static void BinarySearchTask() {
		
	 BinarySearchTree<Integer> t = new BinarySearchTree<>( );
		long startTime, endTime;

		int n = 100000; 
		System.out.println("\nCreate the binary tree...");
		long totalTimeTaken=0;
	
		
		//BinarySearch INSERTION
		startTime = System.nanoTime();
		for (int i = 1; i <= n; i++) {
			
			t.insert(i);
			//t.checkBalance();
			
		}
		endTime = System.nanoTime();
		totalTimeTaken=(endTime-startTime);
		
		System.out.println("Average time to insert 100000 keys: " +totalTimeTaken/n+ " nanoseconds");
		
		//SEARCH TIME FOR BinarySearchTime
		totalTimeTaken=0;
		
		
		int c=0;
		startTime = System.nanoTime();
		for (int i = 1; i <= n; i++) {
			int Random = (int)(Math.random()*100000);
			if (t.contains(Random))
				c=c+1;
				
		}
		endTime = System.nanoTime();
		
		//System.out.println(c+"keys found");
		
		totalTimeTaken=(endTime-startTime);
		System.out.println("Average time for searching 100000 random strings: " + totalTimeTaken/n + " nanoseconds");
		
		//BinarySearchTree deletion
		totalTimeTaken=0;
	
		
		startTime = System.nanoTime();
		for (int i = n; i >= 1; i--) {
			t.remove(i);
			//t.checkBalance();
		}
		endTime = System.nanoTime();
		totalTimeTaken=(endTime-startTime);
		System.out.println("Average time to delete 100000 keys: " + totalTimeTaken/n + " nanoseconds");

		//System.out.println("Tree after removals:");
		//t.printTree();
	}
public static void RedBlackBSTTASK() {
	
	RedBlackBST<Integer, Integer> t = new RedBlackBST<Integer, Integer>();
	long startTime, endTime;
	long totalTimeTaken=0;

	int n = 100000; 
	System.out.println("\nCreate the RedBlackBST tree...");
	startTime = System.nanoTime();
	for (int i = 1; i <= n; i++) {
		t.put(i,i);
		//t.checkBalance();
	}
	endTime = System.nanoTime();
	totalTimeTaken=(endTime-startTime);
	System.out.println("Average time to insert 100000 keys: " +totalTimeTaken/n+ " nanoseconds");
	
	totalTimeTaken=0;

	int c=0;
	startTime = System.nanoTime();
	for (int i = 1; i <= n; i++) {
		int Random = (int)(Math.random()*100000);
		if (t.contains(Random))
			c=c+1;
			
	}
	endTime = System.nanoTime();
	
	System.out.println(c+"keys found");
	totalTimeTaken=(endTime-startTime);
	System.out.println("Average time for searching 100000 random strings: " + totalTimeTaken/n + " nanoseconds");
	
	totalTimeTaken=0;
	
	startTime = System.nanoTime();
	for (int i = n; i >= 1; i--) {
		t.delete(i);
		
	}
	endTime = System.nanoTime();
	totalTimeTaken=(endTime-startTime);
	System.out.println("Average time to delete 100000 keys: " + totalTimeTaken/n + " nanoseconds");

	//System.out.println("Tree after removals:");
	//t.printTree();
}
public static void SplayTreeTASK() {
	
	SplayTree<Integer> t = new SplayTree<Integer>( );
	long startTime, endTime;
	long totalTimeTaken=0;
	long Time=0;
	int n = 100000; 
	System.out.println("\nCreate the Splay tree...");
	startTime = System.nanoTime();
	for (int i = 1; i <= n; i++) {
		t.insert(i);
		//t.checkBalance();
	}
	endTime = System.nanoTime();
	Time=(endTime-startTime);
	totalTimeTaken=+Time;
	System.out.println("Average time to insert 100000 keys: " +totalTimeTaken/n+ " nanoseconds");
	
	totalTimeTaken=0;
	Time=0;
	int c=0;
	startTime = System.nanoTime();
	for (int i = 1; i <= n; i++) {
		int Random = (int)(Math.random()*100000);
		if (t.contains(Random))
			c=c+1;
			
	}
	endTime = System.nanoTime();
	
	//System.out.println(c+"keys found");
	
	totalTimeTaken=(endTime-startTime);
	System.out.println("Average time for searching 100000 random strings: " + totalTimeTaken/n + " nanoseconds");
	
	totalTimeTaken=0;
	Time=0;
	startTime = System.nanoTime();
	for (int i = n; i >= 1; i--) {
		t.remove(i);
		//t.checkBalance();
	}
	endTime = System.nanoTime();
	totalTimeTaken=(endTime-startTime);
	System.out.println("Average time to delete 100000 keys: " + totalTimeTaken/n + " nanoseconds");

	//System.out.println("Tree after removals:");
	//t.printTree();
}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AVLTASK();
		BinarySearchTask();
		RedBlackBSTTASK();
		SplayTreeTASK();

	}
	

}

