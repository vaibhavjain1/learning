package btree;

import java.util.*;

public class TreeViews {
    // top view via horizontal distance + BFS.
    // Let say horizontal distance of root x is 0
    // Horizontal distance of left node = horizontalDistance(x) - 1
    // Horizontal distance of right node = horizontalDistance(x) + 1
    // top node at each horizontal distance will be visible
    Map<Integer, Node> topMap = new TreeMap<>();
    Queue<Node> topQueue = new LinkedList<>();
    Map<Node, Integer> topLevelMap = new HashMap<>();
    void top_Mirror(Node root, int level){
        if (root != null) {
            topQueue.add(root);
            topLevelMap.put(root, level);

            while(topQueue.size() != 0) {
                Node node = topQueue.poll();
                Integer currLevel = topLevelMap.get(node);
                if(topMap.get(currLevel) == null){
                    topMap.put(currLevel, node);
                }

                if (node.left != null) {
                    topQueue.add(node.left);
                    topLevelMap.put(node.left, topLevelMap.get(node) - 1);
                }
                if(node.right != null) {
                    topQueue.add(node.right);
                    topLevelMap.put(node.right, topLevelMap.get(node) + 1);
                }
            }
        }
    }


    // Bottom view is just opposite of top view
    // with map key value getting overridden everytime
    Map<Integer, Node> bottomMap = new TreeMap<>();
    Queue<Node> bottomQueue = new LinkedList<>();
    Map<Node, Integer> bottomLevelMap = new HashMap<>();
    void bottom_Mirror(Node root, int level) {
        if (root != null) {
            bottomQueue.add(root);
            bottomLevelMap.put(root, level);

            while(bottomQueue.size() != 0) {
                Node node = bottomQueue.poll();
                Integer currLevel = bottomLevelMap.get(node);
                bottomMap.put(currLevel, node);


                if (node.left != null) {
                    bottomQueue.add(node.left);
                    bottomLevelMap.put(node.left, bottomLevelMap.get(node) - 1);
                }
                if (node.right != null) {
                    bottomQueue.add(node.right);
                    bottomLevelMap.put(node.right, bottomLevelMap.get(node) + 1);
                }
            }
        }
    }

    Map<Integer, Node> leftMap = new HashMap();
    void left_Mirror(Node root, int level) {
        if(root != null){
            if(leftMap.get(level) == null) {
                leftMap.put(level, root);
            }
            if(root.left != null) {
                left_Mirror(root.left, level + 1);
            }
            if (root.right != null) {
                left_Mirror(root.right, level + 1);
            }
        }
    }

    Map<Integer, Node> rightMap = new HashMap();
    void right_Mirror(Node root, int level) {
        if (root != null) {
            rightMap.put(level, root);

            if (root.left != null) {
                right_Mirror(root.left, level + 1);
            }
            if (root.right != null) {
                right_Mirror(root.right, level + 1);
            }
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        Node.printTreeDiagram(root);
        TreeViews treeViewsObj = new TreeViews();

        System.out.print("\nLeft View:");
        treeViewsObj.left_Mirror(root, 0);
        for (Map.Entry<Integer, Node> entry: treeViewsObj.leftMap.entrySet()){
            System.out.print(entry.getValue().key + " ");
        }

        System.out.print("\nRight View:");
        treeViewsObj.right_Mirror(root, 0);
        for (Map.Entry<Integer, Node> entry: treeViewsObj.rightMap.entrySet()){
            System.out.print(entry.getValue().key + " ");
        }

        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.right = new Node(4);
        root1.left.right.right = new Node(5);
        root1.left.right.right.right = new Node(6);
        Node.printTreeDiagram(root1);
        System.out.print("\nTop View:");
        treeViewsObj.top_Mirror(root1, 0);
        for (Map.Entry<Integer, Node> entry: treeViewsObj.topMap.entrySet()){
            System.out.print(entry.getValue().key + " ");
        }

        System.out.print("\nBottom View:");
        treeViewsObj.bottom_Mirror(root1, 0);
        for (Map.Entry<Integer, Node> entry: treeViewsObj.bottomMap.entrySet()){
            System.out.print(entry.getValue().key + " ");
        }
    }
}
