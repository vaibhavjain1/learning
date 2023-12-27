/*
 * Design a stack using Linked List
 * Means you need to maintain the insertion order starting from head.
 * Design Push and POP
 */
package linkedList;

public class LinkedListAsStack {

	class Node{
		int number;
		Node next;
		Node(int number){
			this.number = number;
			this.next = null;
		}
	}
	
	Node head;
	
	public void insertNode(int number){
		if(head==null){
			head = new Node(number);
		}else{
			Node temp = head;
			while(temp.next!=null){
				temp = temp.next;
			}
			Node newnode = new Node(number);
			temp.next = newnode;
		}
	}
	
	public void deleteNode(){
		if(head==null)
			System.out.println(-1);
		else{
			Node temp = head;
			if(temp.next==null){
				System.out.println(temp.number);
				head = null;
			}else{
				while(temp.next.next!=null)
					temp = temp.next;
				System.out.println(temp.next.number);
				temp.next = null;
			}
		}
	}
	
	public void printLinkedList(){
		Node temp = head;
		while(temp!=null){
			System.out.println("->"+temp.number);
			temp=temp.next;
		}
	}
	
	public static void main(String[] args) {
		LinkedListAsStack obj = new LinkedListAsStack();
		obj.insertNode(10);;
		obj.insertNode(20);
		obj.insertNode(30);
		obj.deleteNode();
		obj.insertNode(40);
		obj.printLinkedList();
	}
}
