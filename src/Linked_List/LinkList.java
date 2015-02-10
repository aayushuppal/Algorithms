package Linked_List;

public class LinkList {
	static Node root;
	Node last;
public static void main(String[] args) {
	LinkList pob = new LinkList();
	pob.addLast("Thibaut Courtois", 13);
	pob.addLast("Branislav Ivanovic", 02);
	pob.addLast("Filipe Luis", 03);
	pob.addLast("Cesc Fàbregas", 04);
	pob.addLast("Kurt Zouma", 05);
	pob.addLast("Eden Hazard", 10);
	pob.addLast("Didier Drogba", 11);
	root = pob.delNode(11);
	root = pob.delNode(10);
	root = pob.delNode(02);
	root = pob.delNode(13);
}
	
public class Node{
	Node next = null;
	String nodeName;
	int nodeVal;
	
	public Node(String a, int b){
		this.nodeName = a;
		this.nodeVal = b;
	}
	
}	

public void addLast(String a, int b){
	Node newNode = new Node(a,b);
	//Node focusNode;
	
	if (root == null){
		root = newNode;
		last = root;
		System.out.println("1");
	}
	else{ 
		last.next = newNode;
		last = last.next;
		System.out.println("2");
		
		/*
		 * focusNode = root;
	while(focusNode.next != null){
			focusNode = focusNode.next;
		}
		focusNode.next = newNode;
		System.out.println("2");
		*/
	}
}
public Node delNode(int a){
	Node n = root;
	if(n.nodeVal == a){
		root = n.next;
		System.out.println("sddsfdadsa");
		return root;
	}
	else {
		while(n.next != null){
			if (n.next.nodeVal == a){
				n.next = n.next.next;
				System.out.println("sdadsa");
				return root;
			}
			n = n.next;
		}
		return root;
	}
}


}
