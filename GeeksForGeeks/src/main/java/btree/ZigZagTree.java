package btree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ZigZagTree {

    Stack<Node> leftStack = new Stack<>();
    Stack<Node> rightStack = new Stack<>();
    void printZigZag(Node root){
        if (root != null) {
            leftStack.add(root);
            while(!leftStack.empty() || !rightStack.empty()){
                while (!leftStack.empty()){
                    Node node = leftStack.pop();
                    System.out.print(node.key + " ");
                    if(node.left != null)
                        rightStack.add(node.left);
                    if(node.right != null)
                        rightStack.add(node.right);
                }
                while (!rightStack.empty()){
                    Node node = rightStack.pop();
                    System.out.print(node.key + " ");
                    if (node.right != null)
                        leftStack.add(node.right);
                    if (node.left !=null)
                        leftStack.add(node.left);
                }
            }
        }
    }

    public static void main(String[] args) {
        Node root = new Node(18);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(60);
        root.left.right = new Node(34);
        root.right.left = new Node(45);
        root.right.right = new Node(65);
        root.left.left.left = new Node(12);
        root.left.left.right = new Node(50);
        root.left.right.left = new Node(98);
        root.left.right.right = new Node(82);
        root.right.left.left = new Node(31);
        root.right.left.right = new Node(59);
        root.right.right.left = new Node(71);
        root.right.right.right = new Node(41);
        Node.printTreeDiagram(root);
        System.out.print("Zig Zag order of tree: ");
        new ZigZagTree().printZigZag(root);
    }
}
