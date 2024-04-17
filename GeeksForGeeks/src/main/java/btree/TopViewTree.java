package btree;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class TopViewTree {

    Map<Integer, Integer> distanceMap = new TreeMap<>(Collections.reverseOrder());
    void horizonatalDistance(Node root, int distance){
        if(root == null)
            return;
        else{
            if(distanceMap.get(distance)==null)
                distanceMap.put(distance, root.key);
            horizonatalDistance(root.left, distance + 1);
            horizonatalDistance(root.right, distance - 1);
        }
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        node.right.left = new Node(6);
        node.right.right = new Node(7);

        Node.printTreeDiagram(node);
        TopViewTree obj = new TopViewTree();
        obj.horizonatalDistance(node, 0);
        for(Map.Entry<Integer, Integer> entry: obj.distanceMap.entrySet()){
            System.out.println(entry.getKey() +" -> " + entry.getValue());
        }
    }
}
