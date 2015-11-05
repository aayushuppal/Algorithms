/*

Given a singly linked list, modify the value of first half nodes such that :

1st node’s new value = the last node’s value - first node’s current value
2nd node’s new value = the second last node’s value - 2nd node’s current value,
and so on …

 NOTE : 
* If the length L of linked list is odd, then the first half implies at first floor(L/2) nodes. So, if L = 5, the first half refers to first 2 nodes. 
* If the length L of linked list is even, then the first half implies at first L/2 nodes. So, if L = 4, the first half refers to first 2 nodes. 
Example :

Given linked list 1 -> 2 -> 3 -> 4 -> 5,

You should return 4 -> 2 -> 3 -> 4 -> 5
as

for first node, 5 - 1 = 4
for second node, 4 - 2 = 2
Try to solve the problem using constant extra space.

*/


/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
	public ListNode subtract(ListNode a) {
	    Stack<ListNode> leftStack = new Stack<>();
	    ListNode slow = a;
	    ListNode fast = a;
	    
	    while(fast.next != null && fast.next.next != null){
	        leftStack.push(slow);
	        slow = slow.next;
	        fast = fast.next.next;
	    }
	    
	    ListNode rightStart;
	    ListNode mid;
	    
	    if (fast.next == null) {
	        mid = slow;
	        rightStart = slow.next;
	    } else {
	        leftStack.push(slow);
	        mid = slow.next;
	        rightStart = slow.next;
	    }
	    
	    while(!leftStack.isEmpty()){
	        ListNode temp = leftStack.pop();
	        int A = temp.val;
	        int B = rightStart.val;
	        rightStart = rightStart.next;
	        temp.val = B-A;
	    }
	    return a;
	}
}
