package practise.btree;

import btree.Node;

public class PrintNodesKDistance {

	public static void printk(Node root, int k){
		if(root==null)
			return;
		else{
			if(k==0)
				System.out.println("Node @ distance k is:"+root.key);
			else{
				if(root.left!=null)
					printk(root.left,k-1);
				if(root.right!=null)
					printk(root.right,k-1);
			}
		}
	}
	
	
	Node root;
	public static void main(String[] args) {
		PrintNodesKDistance obj = new PrintNodesKDistance();
		obj.root = new Node(1);
		obj.root.left = new Node(2);
		obj.root.right = new Node(3);
		obj.root.left.left = new Node(4);
		obj.root.left.right = new Node(5);
		obj.root.right.left = new Node(6);
		obj.root.right.right = new Node(7);
		obj.root.right.right.right = new Node(8);
		obj.root.right.right.right.left = new Node(9);
		Node.printTreeDiagram(obj.root);
		printk(obj.root, 3);
	}

}
