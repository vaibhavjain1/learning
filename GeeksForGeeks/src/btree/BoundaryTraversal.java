package btree;

public class BoundaryTraversal {

	Node root;
	
	public void printBoundary(){
		System.out.print(root.key+" -> ");
		printLeftTillLeaf(root);
		printLeafNodes(root);
		printRightTillLeaf(root);
	}
	
	public void printLeafNodes(Node root){
		if(root==null)
			return;
		else{
			if(root.left==null && root.right==null)
				System.out.print(root.key+" -> ");
			printLeafNodes(root.left);
			printLeafNodes(root.right);
		}
	}
	public void printRightTillLeaf(Node root){
		if(root.right.right==null){
			return;
		}else{
			printRightTillLeaf(root.right);
			System.out.print(root.right.key+" -> ");
		}
	}
	
	public void printLeftTillLeaf(Node root){
		if(root.left.left==null){
			return;
		}else{
			System.out.print(root.left.key+" -> ");
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
		
		BoundaryTraversal obj = new BoundaryTraversal();
		obj.root = new Node(1);
		obj.root.left = new Node(2);
		obj.root.right = new Node(3);
		obj.root.left.left = new Node(4);
		obj.root.left.right = new Node(5);
		obj.root.right.left = new Node(6);
		obj.root.right.right = new Node(7);
		obj.root.right.right.right = new Node(8);
		Node.printTreeDiagram(obj.root);
		System.out.println("");
		obj.printBoundary();
	}

}
