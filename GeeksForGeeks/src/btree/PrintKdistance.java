package btree;

public class PrintKdistance {

	Node root;
	
	public void getNodesKdistance(int distance){
		kDistance(root,distance);
	}
	
	private void kDistance(Node root, int distance) {
		if (root==null) 
			return;
		else{
			if(distance==0)
				System.out.println("Value at specified distance "+ root.key);
			if(root.left!=null)
			kDistance(root.left, distance-1);
			if(root.right!=null)
			kDistance(root.right, distance-1);
			return;
		}
		
	}
	
	public static void main(String[] args) {
		/*
		 			  1
		 		   /     \
		 		  2       3
		 		/   \   /   \
		 	   4	 5 6     7
		 	   		  \		  \
		 	   		   8	   9
		 */
		
		PrintKdistance obj = new PrintKdistance();
		obj.root = new Node(1);
		obj.root.left = new Node(2);
		obj.root.right = new Node(3);
		obj.root.left.left = new Node(4);
		obj.root.left.right = new Node(5);
		obj.root.right.left = new Node(6);
		obj.root.right.right = new Node(7);
		obj.root.right.right.right = new Node(9);
		obj.root.left.right.right = new Node(8);
		Node.printTreeDiagram(obj.root);
		System.out.println();
		obj.getNodesKdistance(3);
	}

}
