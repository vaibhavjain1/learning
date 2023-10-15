package btree;

public class SwapAdjacentLeaf {

	Node root;
	
	public void swapLeaf(Node root, Node swap) {
		if(root!=null) {
		if(isLeaf(root.left)) {
			if(swap!=null) {
				int temp = root.left.key;
				root.left.key = swap.key;
				swap.key = temp;
				swap = null;
			}
			else {
				swap = root.left;
			}
		}
		
		if(isLeaf(root.right)) {
			if(swap!=null) {
				int temp = root.right.key;
				root.right.key = swap.key;
				swap.key = temp;
				swap = null;
			}
			else {
				swap = root.right;
			}
		}
		swapLeaf(root.left,swap);
		swapLeaf(root.right,swap);
		}
	}
	
	public boolean isLeaf(Node root) {
		if(root==null)
			return false;
		if(root.left ==  null && root.right == null)
			return true;
		else
			return false;
	}
	
	public static void main(String[] args) {
		/*
		  1									1
    	/  \							   / \	
       2    3							  2   3
 	  /    / \                =>         /   / \
	 4    5   6 						7   5   6
         / \ /  \                          / \ / \
        7  8 9  10						  4  9 8 10
     */
		
		SwapAdjacentLeaf obj = new SwapAdjacentLeaf();
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
		obj.swapLeaf(obj.root, null);
		Node.printTreeDiagram(obj.root);
	}
}
