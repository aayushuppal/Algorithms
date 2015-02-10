package Cormen;

public class prob2_6 {
	static Node head;
	static Node last;
	
public static void main(String[] args) {
	prob2_6 pcll = new prob2_6();
	pcll.addLast(10);
	pcll.addLast(11);
	pcll.addLast(10);
	pcll.addLast(12); 
	
	pcll.retString(head);
	
	/* if (last.next == head){
		System.out.println("circular linked list");
	}
	else {
		System.out.println("not a circular linked list");
	} */
	
	
	
}

public class Node{
	Node next;
	int nodeVal;
	
	public Node(int b){
		this.nodeVal = b;
	}
}

public void addLast(int b){
	Node newNode = new Node(b);
	
	if (head == null){
		head = newNode;
		last = head;
		last.next = head;
	}
	else{
		last.next = newNode;
		last = last.next;
		last.next = head;
	}
}

public void retString(Node hd){
	Node n;
	n = hd;
	System.out.print(n.nodeVal+" ");
	n = n.next;
	while(n != head){
		System.out.print(n.nodeVal+" ");
		n = n.next;
	}
	
}

}
