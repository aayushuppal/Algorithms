package Stacks;

public class stack {
	Node top;
	
	public void push(int c){
		Node curr = new Node(c);
		curr.next = top;
		top = curr;
	}
	
	public Node pop(){
		Node t = top;
		top = top.next;
		return t;
	}
	public void peek(){
		if(top != null)
		System.out.println(top.val);
	}
	
	public static void main(String[] args) {
	stack st1 = new stack();
	st1.push(12);
	st1.push(11);
	st1.push(10);
	st1.push(9);
	st1.push(8);
	
	st1.peek();
		
		while (st1.top != null){
			System.out.println(st1.pop().val);
		}
	}
	
	public class Node{
		int val;
		Node next;
		
		Node(int a){
			this.val = a;
		}
	}

}
