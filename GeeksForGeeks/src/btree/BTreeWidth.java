package btree;

import java.util.LinkedList;
import java.util.Queue;

public class BTreeWidth {

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
	
	public void getMaxWidth(){
		int maxWidthOfTree = maxWidhth(root,0);
		System.out.println("Max width of the tree :"+maxWidthOfTree);
	}
	
	private int maxWidhth(Node root, int height) {
		if (root==null) 
			return height;
		else{
			int lheight = maxWidhth(root.left, height+1);
			int rheight = maxWidhth(root.right, height+1);
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
		
		BTreeWidth obj = new BTreeWidth();
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
		obj.getMaxWidth();
	}

}
