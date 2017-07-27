package btree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BTreeBFSDFS {
	
	Node root;
	
	public void printDFS(){
		DFS_inorder(root);
	}
	
	public void DFS_inorder(Node root){
		if(root==null)
			return;
		else{
			DFS_inorder(root.left);
			System.out.print(root.key+" -> ");
			DFS_inorder(root.right);
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
		 */
		
		BTreeBFSDFS obj = new BTreeBFSDFS();
		obj.root = new Node(1);
		obj.root.left = new Node(2);
		obj.root.right = new Node(3);
		obj.root.left.left = new Node(4);
		obj.root.left.right = new Node(5);
		obj.root.right.left = new Node(6);
		obj.root.right.right = new Node(7);
		obj.printDFS();
		System.out.println();
		obj.printBFS();
		System.out.println();
		Node.printTreeDiagram(obj.root);
	}

}
