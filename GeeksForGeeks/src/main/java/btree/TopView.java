package btree;

import java.util.HashMap;
import java.util.Map;

public class TopView {

	Node root;

	//wrong code
	/*public static void printTopView(Node root) {
		Map<Integer,Integer> myMap = new HashMap<>();
		horizontalDistance(root, 0, myMap);
	}

	public static void horizontalDistance(Node root, int dist, Map<Integer, Integer> myMap) {
		if(root ==null)
			return;
		else {
			if(myMap.get(dist)==null) {
				myMap.put(dist, root.key);
				System.out.println(root.key);
			}
			horizontalDistance(root.left, dist-1, myMap);
			horizontalDistance(root.right, dist+1, myMap);
		}
	
	}*/

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
		Node.printTreeDiagram(obj.root);
		//obj.printTopView(obj.root);
	}
	
}
