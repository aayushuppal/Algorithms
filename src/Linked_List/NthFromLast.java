package Linked_List;

import Linked_List.MyLinkedList.Node;

public class NthFromLast {
	
	static int i = 0;
	public static void main(String[] args) {
		MyLinkedList ll = new MyLinkedList();
		ll.addNode(9);
		ll.addNode(6);
		ll.addNode(1);
		ll.addNode(2);
		ll.addNode(4);
		ll.addNode(7);
		
		//Node n = NthNodeFromLast(ll.head,2);
		//RecursiveNthLast(ll.head,2);
		System.out.println(RecursiveNthLast(ll.head,2).val);
		//System.out.println(n.val);
	}
	
	public static Node NthNodeFromLast(Node head, int a){
		int len = 0;
		Node curr = head;
		while(curr!=null){
			len++;
			curr = curr.next;
		}
		for (int i=0; i<len-a; i++){
			head = head.next;
		}
		return head;
	}
	
	public static Node RecursiveNthLast(Node head, int a){
		if(head == null) return null;
		Node retNode = RecursiveNthLast(head.next,a);	
		if(i == a){
			return retNode;	
		}
        i++;
		return head;		
	}
	
}
