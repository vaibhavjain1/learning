package linkedList;

public class SwapNodesWithoutSwappingData {
	
	class Node {
		int value;
		Node next;

		Node(int value) {
			this.value = value;
			next = null;
		}
	}

	Node head;

	public void printLinkedList() {
		Node temp = head;
		System.out.println("\n------Linked List------");
		while (temp != null) {
			System.out.print(temp.value);
			temp = temp.next;
			if (temp != null)
				System.out.print(" -> ");
		}
	}
	
	public void insertIntoLinkedList(int value){
		if(head==null){
			head = new Node(value);
			return;
		} else {
			Node temp = head;
			while(temp.next!=null){
				temp = temp.next;
			}
			temp.next = new Node(value);
		}
	}
	
	public void swapNodesWithoutChangingData(int first, int second) {
		Node start = this.head;
		Node swap1 = null, swap2 = null, prevswap1 = null, prevswap2 = null;

		if (start.value == first)
			swap1 = start;
		if (start.value == second)
			swap2 = start;

		while (start.next != null) {
			if (start.next.value == first) {
				prevswap1 = start;
				swap1 = start.next;
			}
			if (start.next.value == second) {
				prevswap2 = start;
				swap2 = start.next;
			}
			start = start.next;
		}

		if (swap1 == null || swap2 == null || swap1 == swap2)
			return;

		if (prevswap1 != null) {
			prevswap1.next = swap2;
		} else {
			this.head = swap2;
		}
		if (prevswap2 != null) {
			prevswap2.next = swap1;
		} else {
			this.head = swap1;
		}
		// Swapping

		start = swap1.next;
		swap1.next = swap2.next;
		swap2.next = start;
	}

	public static void main(String[] args) {
		SwapNodesWithoutSwappingData obj = new SwapNodesWithoutSwappingData();
		obj.insertIntoLinkedList(10);
		obj.insertIntoLinkedList(20);
		obj.insertIntoLinkedList(30);
		obj.insertIntoLinkedList(40);
		obj.insertIntoLinkedList(50);
		obj.printLinkedList();
		obj.swapNodesWithoutChangingData(10, 40);
		obj.printLinkedList();
	}
}
