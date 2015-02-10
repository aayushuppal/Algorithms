package Stacks;

public class stackprob {
	static int genthresh = 5;
	public static void main(String[] args) {
		stackprob pob = new stackprob();
		/*
		stack st1 = new stack(true,10,5);
		st1.push(11);
		st1.push(12);
		st1.push(13);
		st1.push(14);
		System.out.println(st1.full);

		stack st2 = new stack(true,20,4);
		st2.push(21);
		st2.push(22);
		st2.push(23);
		System.out.println(st2.full);
		
		stack st3 = new stack(true,30,10);
		st3.push(31);
		st3.push(32);
		st3.push(33);
		st3.push(34);
		System.out.println(st3.full);
		*/
		SetofStacks set1 = new SetofStacks(true, 10);
	}
	
	public static class SetofStacks{
		stack ss;
		boolean a = ss.full;
		
		SetofStacks(boolean newSet, int val){
			if (newSet == true){
				new stack(true,val,genthresh);
			}
		}
		
		public void sspush(int a){
			//stack ssobj = new stack();
			//stuck here how to to call push for the particular stack
		}
	}
	
	public static class stack{
		static Node top;
		static int count;
		boolean full;
		
		int threshold;
		stack(boolean b, int a, int t){
			count = 0;
			this.threshold = t;
			this.full = false;
			if(b == true){
				push(a);
			}
			
		}
		public void push(int a){
			if(count < threshold-1){
				Node t = new Node(a);
				t.next = top;
				top = t;
				count++;
			}
			else if(count == threshold-1){
				Node t = new Node(a);
				t.next = top;
				top = t;
				count++;
				this.full = true;
			}
			else{
				System.out.println("stack full");
			}
			
		}
		
		public Node pop(){
			Node t = top;
			top = top.next;
			return t;
		}
	}
	
	public static class Node{
		int val;
		Node next;
		Node(int a){
			this.val = a;
		}
	}
}
