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
		System.out.println("------Linked List------");
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
	
	public void swapNodesWithoutChangingData(int first,int second){
		// TODO
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
