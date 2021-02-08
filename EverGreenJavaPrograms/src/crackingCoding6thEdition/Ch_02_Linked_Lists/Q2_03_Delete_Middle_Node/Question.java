package crackingCoding6thEdition.Ch_02_Linked_Lists.Q2_03_Delete_Middle_Node;

import crackingCoding6thEdition.CtCILibrary.AssortedMethods;
import crackingCoding6thEdition.CtCILibrary.LinkedListNode;

public class Question {

	public static boolean deleteNode(LinkedListNode n) {
		if (n == null || n.next == null) {
			return false; // Failure
		} 
		LinkedListNode next = n.next; 
		n.data = next.data; 
		n.next = next.next; 
		return true;
	}
	
	public static void main(String[] args) {
		LinkedListNode head = AssortedMethods.randomLinkedList(10, 0, 10);
		System.out.println(head.printForward());
		deleteNode(head.next.next.next.next); // delete node 4
		System.out.println(head.printForward());
	}

}
