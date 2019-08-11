package btree;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class BTreeWidth {

	Node root;
	
	public void getMaxWidth(){
		Map<Integer,Integer> widthMap = new HashMap<>();
		traverseTreeWithHeight(root,0, widthMap);
		Set<Entry<Integer, Integer>> entrySet = widthMap.entrySet();
		int maxWidthOfTree = 0;
		for (Entry<Integer, Integer> entry : entrySet) {
			if(entry.getValue()>maxWidthOfTree)
				maxWidthOfTree = entry.getValue();
		}
		System.out.println("Max width of the tree :"+maxWidthOfTree);
	}
	
	private int traverseTreeWithHeight(Node root, int height, Map<Integer,Integer> widthMap) {
		if (root==null) 
			return height;
		else{
			if(widthMap.get(height)==null)
				widthMap.put(height, 1);
			else
				widthMap.put(height, widthMap.get(height)+1);

			int lheight = traverseTreeWithHeight(root.left, height+1, widthMap);
			int rheight = traverseTreeWithHeight(root.right, height+1, widthMap);
			return Math.max(lheight,rheight);
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
		
		BTreeWidth obj = new BTreeWidth();
		obj.root = new Node(1);
		obj.root.left = new Node(2);
		obj.root.right = new Node(3);
		obj.root.left.left = new Node(4);
		obj.root.left.right = new Node(5);
		obj.root.right.left = new Node(6);
		obj.root.right.right = new Node(7);
		obj.root.right.right.right = new Node(8);
		Node.printTreeDiagram(obj.root);
		System.out.println();
		obj.getMaxWidth();
	}

}
