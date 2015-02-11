package Linked_List;
// Approach - store address of nodes in a hashset and then compare O(m+n) space and time

import Linked_List.MyLinkedList.Node; // avoid this by putting Node in a separate class 
import java.util.HashSet;

public class MergePointLinkList {

	public static void main(String[] args) {
	MyLinkedList ll1 = new MyLinkedList();
	ll1.addNode(2);
	ll1.addNode(7);
	ll1.addNode(3);
	ll1.addNode(5);
	ll1.addNode(4);
	ll1.addNode(1);
	
	MyLinkedList ll2 = new MyLinkedList();
	ll2.addNode(10);
	ll2.addNode(11);
	ll2.addNode(12);
	ll2.lastNode(ll2.head).next = ll1.head.next.next;
	
	Node mergerNode = findMergePoint(ll1.head,ll2.head);
	int disp = mergerNode != null ? mergerNode.val:0; //0 denotes null node
	System.out.println(disp);
	}
	
	public static Node findMergePoint(Node head1, Node head2){
		HashSet<Node> hset = new HashSet<Node>();
		Node curr1 =head1; 
		Node curr2 =head2;
		
		while (curr1.next != null){
			hset.add(curr1);
			curr1 = curr1.next;
		}
		hset.add(curr1);
		
		while (curr2.next != null){
			if (hset.contains(curr2)){	return curr2;}
			curr2 = curr2.next;
		}
		if (hset.contains(curr2)){	return curr2;}
		
		return null;
	}

}
