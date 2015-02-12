package Linked_List;

public class DoublyLinkedList {
	Node head;
	
	public void addNode(int a){
		Node incoming = new Node(a);
		if (head == null){
			head = incoming;
			head.prev = null;
			head.next = null;
		} else {
			Node current = head;
			while(current.next != null){
				current = current.next;
			}
			current.next = incoming;
			current.next.prev = current;
			current.next.next = null;
		}
	}
	
	public Node getLast(){
		Node current = head;
		while(current.next != null){
			current = current.next;
		}
		return current;
	} 
	
	public class Node{
		int val;
		Node next;
		Node prev;
		Node(int a){
			this.val = a;
		}
	}

	
}
