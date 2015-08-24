package Linked_List;

import java.util.LinkedList;

public class AddNumbers {
	// 617 + 95
	public static void main(String[] args){
		LinkedList<Integer> ll1 = new LinkedList<Integer>();
		LinkedList<Integer> ll2 = new LinkedList<Integer>();
		ll1.add(9);
		ll1.add(9);
		ll1.add(9);
		
		ll2.add(9);
		ll2.add(9);
		ll2.add(9);
		
		System.out.println(addUp(ll1, ll2));
		
	}
	
	public static LinkedList<Integer> addUp(LinkedList<Integer> ll1, LinkedList<Integer> ll2) {
		LinkedList<Integer> ll3 = new LinkedList<Integer>();
		int carry = 0;
		while (ll1.peek() != null  || ll2.peek() != null) {
			int l1 =  ll1.peek() != null ? ll1.poll() : 0;
			int l2 =  ll2.peek() != null ? ll2.poll() : 0;
			
			int temp = l1+l2+carry;
			int a,b;
			if (temp > 9) {
				b = temp /10;
				a = temp%10;
			} else {
				b = 0;
				a = temp;
			}
			ll3.add(a);
			carry = b;
			
		}
		
		if (carry > 0) {
			ll3.add(carry);
		}
		return ll3;
	}

}
