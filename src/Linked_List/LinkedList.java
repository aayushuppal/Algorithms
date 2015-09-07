package Linked_List;

public class LinkedList {
	Node head;
	Node current;
	
	LinkedList () {
		head = null;
		current = null;
	}
	
	public void add(int a) {
		if (head == null) {
			head = new Node();
			
			head.val = a;
			head.next = null;
			current =  head;
		} else {
			current.next = new Node();
			current.next.val = a;
			current.next.next = null;
			current = current.next;
		}
		
	}
	
	public void printLinkedList() {
		if (head == null)  {
			System.out.println("empty linked list");
		} else {
			Node temp = head;
			do {
				System.out.println(temp.val);
				temp = temp.next;
			} while (temp != null);
		}
		
	}
	
	public int length() {
		if (head == null)  {
			return 0;
		} else {
			int count = 0;
			Node temp = head;
			do {
				count++;
				temp = temp.next;
			} while (temp != null);
			return count;
		}
	}
	
	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.add(10);
		ll.add(11);
		ll.add(12);
		
		ll.printLinkedList();
	}
}

class Node {
	int val;
	Node next;
	
	Node() { }
	
}
