package btree;

public class MirrorBTree {

	Node root;
	
	public void swapNodes(Node root){
		if(root==null)
			return;
		if(root.left!=null)
			swapNodes(root.left);
		if(root.right!=null)
			swapNodes(root.right);
		Node temp = root.left;
		root.left = root.right;
		root.right = temp;
	}
	
	public static void main(String[] args) {
		MirrorBTree obj = new MirrorBTree();
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
		obj.swapNodes(obj.root);
		Node.printTreeDiagram(obj.root);
	}

}
