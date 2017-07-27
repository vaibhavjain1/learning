package btree;

public class TopView {

	Node root;
	
	public void printTopView(){
		printleftView(root);
		printrightView(root);
	}
	
	private void printrightView(Node root) {
		if(root==null)
			return;
		if(this.root!=root)
		System.out.println(root.key+" -> ");
		printrightView(root.right);
	}

	private void printleftView(Node root) {
		if(root==null)
			return;
		System.out.println(root.key+" -> ");
		printleftView(root.left);
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
		
		TopView obj = new TopView();
		obj.root = new Node(1);
		obj.root.left = new Node(2);
		obj.root.right = new Node(3);
		obj.root.left.left = new Node(4);
		obj.root.left.right = new Node(5);
		obj.root.right.left = new Node(6);
		obj.root.right.right = new Node(7);
		obj.root.right.right.right = new Node(8);
		obj.printTopView();
	}
	
}
