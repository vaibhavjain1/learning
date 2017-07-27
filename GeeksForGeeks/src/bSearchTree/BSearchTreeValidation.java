package bSearchTree;
/*
  	The left subtree of a node contains only nodes with keys less than the node’s key.
	The right subtree of a node contains only nodes with keys greater than the node’s key.
	The left and right subtree each must also be a binary search tree.
	There must be no duplicate nodes.
 */
import btree.Node;

public class BSearchTreeValidation {

	public void validateBSearchTreeRaw(Node root){
		
	}
	
	
	
	public void printDFSinOrderTraversal(Node root){
		if(root==null)
			return;
		else{
			if(root.left!=null)
				printDFSinOrderTraversal(root.left);
			System.out.print(root.key+" ");
			if(root.right!=null)
				printDFSinOrderTraversal(root.right);
		}
	}
	
	Node root;
	public static void main(String[] args) {
		BSearchTreeValidation obj = new BSearchTreeValidation();
		obj.root = new Node(8);
		obj.root.left = new Node(3);
		obj.root.right = new Node(10);
		obj.root.left.left = new Node(2);
		obj.root.left.right = new Node(6);
		obj.root.left.right.left = new Node(1);
		obj.root.left.right.right = new Node(9);
		obj.root.right.right = new Node(14);
		obj.root.right.right.left = new Node(13);
		Node.printTreeDiagram(obj.root);
		obj.printDFSinOrderTraversal(obj.root);
		System.out.println();
		obj.validateBSearchTreeRaw(obj.root);
	}

}
