package Linked_List;
// Approach 1 - store address of nodes in a hashset and then compare O(m+n) space and time.
// Approach 2 - offset from start approach.
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
	ll2.lastNode(ll2.head).next = ll1.lastNode(ll1.head);
	
	//Node mergerNode = findMergePoint_Hashsetapproach(ll1.head,ll2.head);
	Node mergerNode = findMergePoint_Offsetapproach(ll1.head,ll2.head);
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
}
