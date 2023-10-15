package linkedList;

public class ReverseLinkedListInGroupOfGivenSize {

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
	
	public void reverseInGroup(int k){
		head = reverse(3, head, head.next.next);
	}
	
	public Node reverse(int k, Node head, Node tail){
		//Node furtherListNext = tail.next;
		Node prev = head;
		Node curr = prev.next;
		prev.next = null;
		while(prev!=tail){
			Node next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		head = prev;
		return head;
	}
	
	public static void main(String[] args) {
		ReverseLinkedListInGroupOfGivenSize obj =  new ReverseLinkedListInGroupOfGivenSize();
		int givenGroupSize = 3;
		obj.insertIntoLinkedList(10);
		obj.insertIntoLinkedList(20);
		obj.insertIntoLinkedList(30);
		obj.insertIntoLinkedList(40);
		obj.insertIntoLinkedList(50);
		obj.insertIntoLinkedList(60);
		obj.printLinkedList();
		obj.reverseInGroup(givenGroupSize);
		obj.printLinkedList();
	}

}
