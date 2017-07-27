package btree;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class JigJagBTree {
	Node root;
	
	public void printZigZag(){
		Queue<Node> myList = new LinkedList<>();
		myList.add(root);
		BFS(myList);
	}
	boolean flipflop = true;
	
	public void BFS(Queue<Node> nodeList){
		if(nodeList.isEmpty())
			return;
		Queue<Node> myList = new LinkedList<>();
		while(!nodeList.isEmpty()){
			Node temp = nodeList.poll();
			System.out.print(temp.key+" ");
			if(flipflop){
				if(temp.left!=null)
				myList.add(temp.left);
				if(temp.right!=null)
				myList.add(temp.right);
			}else{
				if(temp.right!=null)
				myList.add(temp.right);
				if(temp.left!=null)
				myList.add(temp.left);
			}
		}
		if(flipflop)
			flipflop = false;
		else
			flipflop = true;
		Collections.reverse((List<?>) myList);
		BFS(myList);
	}
	
	public static void main(String[] args) {
		/*
		 			     1
		 		   /         \
		 		  2           3
		 		/   \       /   \
		 	   4	 5     6     7
		 	  / \   / \   / \   / \
		 	 8   9 10 11 12 13 14 15
		 */
		
		JigJagBTree obj = new JigJagBTree();
		obj.root = new Node(1);
		obj.root.left = new Node(2);
		obj.root.right = new Node(3);
		obj.root.left.left = new Node(4);
		obj.root.left.right = new Node(5);
		obj.root.right.left = new Node(6);
		obj.root.right.right = new Node(7);
		obj.root.left.left.left = new Node(8);
		obj.root.left.left.right = new Node(9);
		obj.root.left.right.left = new Node(10);
		obj.root.left.right.right = new Node(11);
		obj.root.right.left.left = new Node(12);
		obj.root.right.left.right = new Node(13);
		obj.root.right.right.left = new Node(14);
		obj.root.right.right.right = new Node(15);
		Node.printTreeDiagram(obj.root);
		System.out.println();
		obj.printZigZag();
	}
}
