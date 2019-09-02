package btree;

import java.util.LinkedList;
import java.util.Queue;

public class LeftViewBTree {

	Node root;
	
	public void printLeftMost(Node root){
		printYo(root, 1);
	}

	public void printYo(Node root, int level){
		if(root==null)
			return;
		else{
			System.out.println("Level: "+level+" root: "+root.key);
			if(root.left!=null)
				printYo(root.left,level+1);
			if(root.right!=null)
				printYo(root.right,level+1);
		}
	}
	public static void main(String[] args) {
		/*
		  1
      	/  \
       2    3
   	  /  \     \
  	 4    5     8 
               /  \
              6    7
       */
		
		LeftViewBTree obj = new LeftViewBTree();
		obj.root = new Node(1);
		obj.root.left = new Node(2);
		obj.root.right = new Node(3);
		obj.root.left.left = new Node(4);
		obj.root.left.right = new Node(5);
		obj.root.right.right = new Node(8);
		obj.root.right.right.left = new Node(6); 
		obj.root.right.right.right = new Node(7);
		obj.root.right.right.right.right = new Node(8);
		Node.printTreeDiagram(obj.root);
		obj.printLeftMost(obj.root);
	}

}
