package uncategorised;

public class MyCircularLinkedList<T> {
    Node head;
    Node tail;
    int size;

    MyCircularLinkedList() {
    }

    public void add(T val) {
	if (head == null) {
	    head = new Node(val);
	    head.next = head;
	    head.prev = head;
	    tail = head;
	    size++;
	    return;
	}
    }

    static class Node<T> {
	T val;
	Node next;
	Node prev;

	Node(T t) {
	    this.val = t;
	}

	Node() {
	}
    }

}