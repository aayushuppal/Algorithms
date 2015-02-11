package Linked_List;
// Approach 1 - store address of nodes in a hashset and then compare O(m+n) space and time.
// Approach 2 - offset from start approach.
// Approach 3 - by finding head of circular linked list approach
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
	ll2.addNode(13);
	ll2.addNode(14);
	ll2.addNode(15);
	ll2.addNode(16);
	//ll2.lastNode(ll2.head).next = ll1.head.next.next;
	
	//Node mergerNode = findMergePoint_Hashsetapproach(ll1.head,ll2.head);
	//Node mergerNode = findMergePoint_Offsetapproach(ll1.head,ll2.head);
	Node mergerNode = findMergePoint_CircularLLapproach(ll1.head,ll2.head);
	int disp = mergerNode != null ? mergerNode.val:0; //0 denotes null node
	System.out.println(disp);
	}
	
	public static Node findMergePoint_Hashsetapproach(Node head1, Node head2){
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
	
	public static Node findMergePoint_Offsetapproach(Node head1, Node head2){
		int len1=0;
		Node curr1 = head1;
		while(curr1.next != null){
			len1++;
			curr1 = curr1.next;
		} len1++;
		
		int len2=0;
		Node curr2 = head2;
		while(curr2.next != null){
			len2++;
			curr2 = curr2.next;
		} len2++;
		
		int offset = len1 > len2 ? len1-len2:len2-len1;
		if(len1 > len2){
		for (int i=0; i<offset;i++){	head1=head1.next;	}	
		} else {
			for (int i=0; i<offset;i++){	head2=head2.next;	}
		}
		curr1 = head1;
		curr2 = head2;
		while(curr1 != curr2 && curr1.next!=null){
			curr1 = curr1.next;
			curr2 = curr2.next;
		}	
		if (curr1 == curr2){ return curr1;}
		return null;
	}

	public static Node findMergePoint_CircularLLapproach(Node head1, Node head2){
		int len1 = 0;
		Node curr1 = head1;
		while(curr1.next != null){	len1++; curr1=curr1.next;	}len1++;
		MyLinkedList cl1 = new MyLinkedList();
		cl1.head = head1;
		cl1.lastNode(cl1.head).next = cl1.head;
		
		Node ptr1 = head2;
		Node ptr2 = head2;
		for (int i=0; i<len1; i++){	ptr1 = ptr1.next;	}
		while(ptr1 != ptr2 && ptr1.next != null){
			ptr1 = ptr1.next;
			ptr2 = ptr2.next;
		} 
		if (ptr1 == ptr2){	return ptr1;	}
		return null;
	}
}
