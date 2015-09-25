// linked list sum in order of digits 1>2>5 + 9>6

public static LlNode getSum(LlNode A, LlNode B) {
	int l1 = getLen(A);
	int l2 = getLen(B);
	int len = l1>l2 ? l1 : l2;
	
	LlNode X = l1<l2 ? A : B;
	for (int i=0; i<Math.abs(l1-l2)); i++){
		LlNode temp = new LlNode(0);
		temp.next = X;
		X = temp;
	}
	if(l1<l2) { 
	A = X; 
	} else {B = X;}
	
	LlNode result = new LlNode();
	int carry = 0;
	// 1>2>5 + 0>9>6
	for (int i=0; i<len-1; i++) {
		int temp = A.data + B.data + carry;
		int carry = temp >=10 ? 1 : 0;
		int value = temp%10;
		result.put(temp);
		
	}
}

// linked list sum in reverse order of digits 125 +96 ; 5>2>1 + 6>9
LinkedListNode addLists (LinkedListNode l1, LinkedListNode l2, int carry) {
	
	if (l1 == null && l2=null && carry == 0){
		return null;
	}
	LinkedListNode result = new LinkedListNode(carry,null,null);
}	