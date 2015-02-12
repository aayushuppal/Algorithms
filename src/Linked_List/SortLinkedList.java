package Linked_List;

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
		
		InsertSort(ll);
	}
	
	public static void InsertSort(MyLinkedList ll){
		int len = ll.getSize();
		for(int i=1;i<len;i++){
			
		}
		
	}
	
}
