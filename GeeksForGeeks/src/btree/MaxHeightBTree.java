package btree;

import java.util.LinkedList;
import java.util.Queue;

public class MaxHeightBTree {

	Node root;
	
	public void getMaxHeight(){
		int maxheight = maxHeight(root,0);
		System.out.println("Max height of the tree :"+maxheight);
	}
	
	private int maxHeight(Node root, int height) {
		if (root==null) 
			return height;
		else{
			int lheight = maxHeight(root.left, height+1);
			int rheight = maxHeight(root.right, height+1);
			return Math.max(lheight,rheight);
		}
		
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
		
		MaxHeightBTree obj = new MaxHeightBTree();
		obj.root = new Node(1);
		obj.root.left = new Node(2);
		obj.root.right = new Node(3);
		obj.root.left.left = new Node(4);
		obj.root.left.right = new Node(5);
		obj.root.right.left = new Node(6);
		obj.root.right.right = new Node(7);
		obj.root.right.right.right = new Node(8);
		Node.printTreeDiagram(obj.root);
		System.out.println();
		obj.getMaxHeight();
	}

}
