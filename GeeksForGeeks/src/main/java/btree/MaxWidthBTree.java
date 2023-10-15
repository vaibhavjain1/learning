package btree;

public class MaxWidthBTree {

	Node root;
	static int maxWidth = 1;
	public void getwidth(Node root){
		int height = getMaxHeight(root,1);
		int maxWidth = getMaxWidth(root,height);
		System.out.println(maxWidth);
	}
	
	private int getMaxWidth(Node root2, int height) {
		int currWidth = 0;
		for (int i = 0; i < height; i++) {
			int cuwidht = widthOfLevel(root2,i);
			if(cuwidht>currWidth)
				currWidth = cuwidht;
		}
		return currWidth;
	}
	static int maxcount;
	private int widthOfLevel(Node root2, int level) {
		int count = 0;
		if(root2==null)
			return 0;
		else{
			if(level==0){
				return 1;
			}else{
				if(root2.left!=null)
				count+=widthOfLevel(root2.left, level-1);
				if(root.right!=null)
				count+=widthOfLevel(root2.right, level-1);
			}
		}
		return count;
	}

	public int getMaxHeight(Node root, int height){
		if(root==null)
			return height;
		int lheight = height,rheight = height;
		if(root.left!=null)
			lheight = getMaxHeight(root.left, height+1);
		if(root.right!=null)
			rheight = getMaxHeight(root.right, height+1);
		if(lheight>rheight)
			return lheight;
		else
			return rheight;
	}
	
	public static void main(String[] args) {
	/*
			  1
	        /  \
	       2    3
	     /  \     \
	    4    5     8 
	              /  \
	             6    7
	 */
		
		MaxWidthBTree obj = new MaxWidthBTree();
		obj.root = new Node(1);
		obj.root.left = new Node(2);
		obj.root.right = new Node(3);
		obj.root.left.left = new Node(4);
		obj.root.left.right = new Node(5);
		obj.root.right.right = new Node(8);
		obj.root.right.right.left = new Node(6); 
		obj.root.right.right.right = new Node(7);
		Node.printTreeDiagram(obj.root);
		obj.getwidth(obj.root);
	}

}
