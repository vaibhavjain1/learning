package btree;


public class LevelOfANode {

	Node root;
	
	boolean notfound = true;
	int currLevel = 1;
	
	public void getLevelOfNode(int keytobesearched){
		getLevel(root, currLevel, keytobesearched);
		if(notfound)
			System.out.println("Key not found level:0");
	}
	
	public void getLevel(Node root, int currLevel, int keytobesearched){
		if(root==null || !notfound)
			return;
		if(root.key==keytobesearched){
			notfound=false;
			System.out.println("Key found at level:"+currLevel);
			return;
		}else{
			getLevel(root.left, currLevel+1, keytobesearched);
			getLevel(root.right, currLevel+1, keytobesearched);
		}
	}
	
	public static void main(String[] args) {
		LevelOfANode obj = new LevelOfANode();
		obj.root = new Node(1);
		obj.root.left = new Node(2);
		obj.root.right = new Node(3);
		obj.root.left.left = new Node(4);
		obj.root.left.right = new Node(5);
		obj.root.right.left = new Node(6);
		obj.root.right.right = new Node(7);
		Node.printTreeDiagram(obj.root);
		
		obj.getLevelOfNode(7);
	}

}
