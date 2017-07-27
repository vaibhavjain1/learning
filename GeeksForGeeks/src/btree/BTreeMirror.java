package btree;

public class BTreeMirror {

	static class Node{
		int key;
		Node left;
		Node right;
		Node(int key){
			this.key = key;
			this.left = null;
			this.right = null;
		}
	}
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

	public void MirrorTree(Node root){
		if(root==null)
			return;
		else{
			MirrorTree(root.left);
			MirrorTree(root.right);
			Node temp = root.left;
			root.left = root.right;
			root.right = temp;
		}
	}
	
	public static void main(String[] args) {
		/*
		 			  1
		 		   /     \
		 		  2       3
		 		/   \   /   \
		 	   4	 5 6     7
		 */
		
		BTreeMirror obj = new BTreeMirror();
		obj.root = new Node(1);
		obj.root.left = new Node(2);
		obj.root.right = new Node(3);
		obj.root.left.left = new Node(4);
		obj.root.left.right = new Node(5);
		obj.root.right.left = new Node(6);
		obj.root.right.right = new Node(7);
		obj.printDFS();
		System.out.println();
		obj.MirrorTree(obj.root);
		obj.printDFS();
	}

}
