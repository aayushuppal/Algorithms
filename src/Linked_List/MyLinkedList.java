package Linked_List;

public class MyLinkedList {
	Node head;
	
	public void addNode(int a){
		Node incomingNode = new Node(a);
		
		if(head==null){
			head = incomingNode;
		} else {
			Node curr = head;
			while(curr.next != null){
				curr = curr.next;
			}
			curr.next = incomingNode;
		}
		
	}
	
	public Node lastNode(Node inputhead){
		Node curr = inputhead;
		while(curr.next != null){
			curr = curr.next;
		}
		return curr;
	}
	public class Node{
		int val;
		Node next;
		Node(int a){
			this.val = a;
		}
	}
	
}
