package btree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.*;

public class MaxSumLevel {
	
	Node root;
	
	public void printBFS(){
		Queue<Node> myList = new LinkedList<>();
		myList.add(root);
		BFS(myList);
	}
	public void BFS(Queue<Node> nodeList){
		if (nodeList.isEmpty())
			return;
		Node temp = nodeList.poll();
		System.out.print(temp.key+" -> ");
		if(temp.left!=null)
			nodeList.add(temp.left);
		if (temp.right!=null) 
			nodeList.add(temp.right);
		BFS(nodeList);
	}
	
	private void getMaxSumLevel() {
		getMax(root,1,0);
		Set<Map.Entry<Integer, Integer>> currSet = myMap.entrySet();
		for (Map.Entry<Integer, Integer> entry : currSet) {
			System.out.println(entry.getKey()+" "+entry.getValue());
		}
	}
	Map<Integer,Integer> myMap = new HashMap<>();
	private void getMax(Node root, int level, int sum){
		if(root==null)
			return;
		if(myMap.containsKey(level))
			myMap.put(level, myMap.get(level)+root.key);
		else
			myMap.put(level, root.key);
		getMax(root.left, level+1, sum);
		getMax(root.right, level+1, sum);
	}
	
	public static void main(String[] args) {
		/*
		 			  1
		 		   /     \
		 		  2       3
		 		/   \   /   \
		 	   4	 5 6     7
		 	   				  \
		 	   				   8
		 */
		
		MaxSumLevel obj = new MaxSumLevel();
		obj.root = new Node(1);
		obj.root.left = new Node(2);
		obj.root.right = new Node(3);
		obj.root.left.left = new Node(4);
		obj.root.left.right = new Node(5);
		obj.root.right.left = new Node(6);
		obj.root.right.right = new Node(7);
		obj.root.right.right.right = new Node(8);
		obj.printBFS();
		System.out.println();
		obj.getMaxSumLevel();
	}

}
