package Linked_List;

public class generateDoublyLinkedList {

	
	public static void main(String[] args) {
	DoublyLinkedList dll1 = new DoublyLinkedList();
	dll1.addNode(1);
	dll1.addNode(2);
	dll1.addNode(3);
	dll1.addNode(4);
	dll1.addNode(5);
	
	System.out.println(dll1.getLast().prev.val);
	
	}

}
