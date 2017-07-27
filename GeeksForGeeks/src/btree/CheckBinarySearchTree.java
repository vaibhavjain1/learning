package btree;

public class CheckBinarySearchTree {

	static class Node{
		int key;
		Node left, right;
		Node(int key){
			this.key = key;
			this.left = null;
			this.right = null;
		}
	}

	Node root;
	
	public void printDFS(){
		dfs(root);
	}
	
	public void dfs(Node root){
		if(root==null)
			return;
		dfs(root.left);
		System.out.print(root.key+" -> ");
		dfs(root.right);
		
	}
	
	public static void main(String[] args) {
		CheckBinarySearchTree obj = new CheckBinarySearchTree();
		obj.root = new Node(8);
		obj.root.left = new Node(3);
		obj.root.right = new Node(10);
		obj.root.left.left = new Node(1);
		obj.root.left.right = new Node(6);
		obj.root.right.right = new Node(14);
		obj.root.left.right.left = new Node(4);
		obj.root.left.right.right = new Node(7);
		obj.root.right.right.left = new Node(13);
		obj.printDFS();
	}

}
