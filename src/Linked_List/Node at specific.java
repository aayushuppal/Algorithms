// Insert a node at a specific position in a linked list
/*
  Insert Node at the end of a linked list 
  head pointer input could be NULL as well for empty list
  Node is defined as 
  class Node {
     int data;
     Node next;
  }
*/
    // This is a "method-only" submission. 
    // You only need to complete this method. 

Node InsertNth(Node head, int data, int position) {
    
	Node current = new Node();
    current.data = data;
    current.next = null;
    
	Node temp = head;
    
    if (position == 0) {
        current.next = head;
        head = current;
    } else {
		Node a = null;
		Node b = null;
		for (int i=0; i<position ; i ++){
			a = temp;
			b = temp.next;
			temp = temp.next;
		}
		a.next = current;
		current.next = b;
	}
    
    return head;
}