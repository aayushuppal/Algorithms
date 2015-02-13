package Linked_List;

import Linked_List.MyLinkedList.Node;

public class SortLinkedList {

	public static void main(String[] args) {
		MyLinkedList ll = new MyLinkedList();
		ll.addNode(9);
		ll.addNode(6);
		ll.addNode(1);
		ll.addNode(2);
		ll.addNode(4);
		ll.addNode(7);
		ll.addNode(8);
		ll.head = MergeSort(ll.head);
		Node curr = ll.head;
		while(curr != null){
			System.out.println(curr.val);
			curr = curr.next;
		}
	}
	
	public static Node MergeSort(Node head){
		if (head == null || head.next == null){
			return head;
		}
		
		Node lengthFinder = head;
		int len = 0;
		while(lengthFinder !=null){
			lengthFinder = lengthFinder.next;
			len++;
		}
		
		int half = len/2;
		Node l = head;
		Node r = head;
		int count = 1; // because it is already at first node, 'r'
		
		while (count != half){
			r = r.next;
			count++;
		}
		Node p = r;
		r = r.next;
		p.next = null;
		
		Node h1 = MergeSort(l);
		Node h2 = MergeSort(r);
		
		
		return Merger(h1,h2);
		
	}
	
	public static Node Merger(Node l, Node h){ // function to merge 2 sorted linked lists
		Node newNode = l.val < h.val ? l:h;
		Node preserveTOP = newNode;
		
		if(l.val < h.val){	l=l.next;	}
		else {	h=h.next;	}
		
		while(l != null && h != null){
			if (l.val < h.val){
				newNode.next = l;
				l=l.next;
			} else {
				newNode.next = h;
				h=h.next;
			}
			newNode = newNode.next;
		}
		while (l!=null){	newNode.next=l;	l=l.next; newNode = newNode.next;	}
		while (h!=null){	newNode.next=h;	h=h.next; newNode = newNode.next;	}
		return preserveTOP;
	}
}
