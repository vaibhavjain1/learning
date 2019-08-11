package btree;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

//https://www.techiedelight.com/find-vertical-sum-given-binary-tree/
public class VerticalSum {

	public static void printVerticalSum(Node root) {
		Map<Integer,Integer> myMap = new HashMap<>();
		horizontalDistance(root, 0, myMap);
		Set<Entry<Integer, Integer>> entrySet = myMap.entrySet();
		for (Entry<Integer, Integer> entry : entrySet) {
			System.out.println(entry.getKey()+"->"+entry.getValue());
		}
	}

	public static void horizontalDistance(Node root, int dist, Map<Integer,Integer> myMap) {
		if(root ==null)
			return;
		else {
			if(myMap.get(dist)==null) {
				myMap.put(dist, root.key);
			}
			else {
				myMap.put(dist, myMap.get(dist)+root.key);
			}
			horizontalDistance(root.left, dist-1, myMap);
			horizontalDistance(root.right, dist+1, myMap);
		}
	}
	
	public static void main(String[] args) {
		/*
				  1
			   /     \
			  2       3
			/   \   /   \
		   4     5 6     7
		   
		   The tree has 5 vertical lines

		Vertical-Line-1 has only one node 4 => vertical sum is 4
		Vertical-Line-2: has only one node 2=> vertical sum is 2
		Vertical-Line-3: has three nodes: 1,5,6 => vertical sum is 1+5+6 = 12
		Vertical-Line-4: has only one node 3 => vertical sum is 3
		Vertical-Line-5: has only one node 7 => vertical sum is 7

		So expected output is 4, 2, 12, 3 and 7
		*/

		TopView obj = new TopView();
		obj.root = new Node(1);
		obj.root.left = new Node(2);
		obj.root.right = new Node(3);
		obj.root.left.left = new Node(4);
		obj.root.left.right = new Node(5);
		obj.root.right.left = new Node(6);
		obj.root.right.right = new Node(7);
		Node.printTreeDiagram(obj.root);
		printVerticalSum(obj.root);
	}
}
