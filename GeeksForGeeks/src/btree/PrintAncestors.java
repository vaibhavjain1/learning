package btree;

import java.util.LinkedList;
import java.util.Queue;

public class PrintAncestors {

	static class Node{
		int key;
		Node left;
		Node right;
		Node(int key){
			this.key = key;
			this.left = null;
			this.right = null;
		}
	}
	Node root;
	int myKey;
	public void printAncestor(int myKey){
		this.myKey = myKey;
		ancestor(root);
	}
	
	public boolean ancestor(Node root){
		if(root==null){
			return false;
		}
		if(root.key==myKey)
			return true;
		else{
			boolean value = ancestor(root.left);
			if(value){
			System.out.print(root.key+" -> ");
			return true;
			}
			value = ancestor(root.right);
			if(value){
				System.out.print(root.key+" -> ");
				return true;
				}
			return false;
		}
	}
	
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
		
		PrintAncestors obj = new PrintAncestors();
		obj.root = new Node(1);
		obj.root.left = new Node(2);
		obj.root.right = new Node(3);
		obj.root.left.left = new Node(4);
		obj.root.left.right = new Node(5);
		obj.root.right.left = new Node(6);
		obj.root.right.right = new Node(7);
		obj.root.left.right.right = new Node(8);
		obj.printAncestor(8);
		System.out.println();
		//obj.printBFS();
	}

}
