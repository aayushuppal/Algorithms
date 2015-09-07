package Linked_List;

public class AddNumbersinOrder {

	public static void main(String[] args) {
		LinkedList ll1 = new LinkedList();
		LinkedList ll2 = new LinkedList();
		ll1.add(9);
		ll1.add(3);
		ll1.add(7);
		
		ll2.add(9);
		ll2.add(3);
		
		int l1 = ll1.length();
		int l2 = ll2.length(); 
		
		if (l1 < l2) {
			ll1 = padZero(ll1, l2-l1);
		}
		if (l2 < l1) {
			ll2 = padZero(ll2, l1-l2);
		}
		ll2.printLinkedList();
		
	}
	
	
	public static LinkedList padZero(LinkedList ll , int pad) {
		Node hd = ll.head;
		if (hd != null) {
			for (int i=0; i<pad; i++){
				Node temp = new Node();
				temp.val = 0;
				temp.next = hd;
				hd = temp;
			}
			ll.head = hd;
		}
		return ll;
	}
}
