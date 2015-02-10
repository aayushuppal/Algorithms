package Stacks;

import java.util.ArrayList;
import java.util.Stack;

import org.w3c.dom.Node;


public class StackSet {
	ArrayList<Stack> stacks = new ArrayList<Stack>();
	int capacity = 5;
	
	public void push(int value){
		Stack activeStack = getLastStack();
		if (activeStack != null && activeStack.size() < capacity){
			activeStack.push(value);
		} else {
			Stack s = new Stack();
			s.push(value);
			stacks.add(s);
		}
	}
	
	public Integer popAtIndex(int a){
		if (a == setSize()){
			return pop();
		}
		else {
			int x = (Integer) stacks.get(a-1).pop();
			rearrange(a-1,setSize()-1);
			return x;
		}
	}
	
	public void rearrange(int a, int b){
	ShiftProcess(a,a+1);	
	}
	
	public void ShiftProcess(int a, int b){
		stacks.get(a).push(removeLast(stacks.get(b)));
	}
	
	public Integer removeLast(Stack s){
		return 0;
	}
	
	public Stack getLastStack(){
		if(stacks.size()==0){
			return null;
		}
		else{
			return(stacks.get(stacks.size()-1));
		}
	}
	
	public Integer setSize(){
		return stacks.size();
		
	}
	
	public Integer pop(){
		Stack activeStack = getLastStack();
		if (activeStack == null)return null;
		int i = (Integer) activeStack.pop();
		if (activeStack.size() == 0)stacks.remove(activeStack);
		return i;
	}
	
	public static void main(String[] args) {
	StackSet set1 = new StackSet();
	set1.push(11);
	set1.push(12);
	set1.push(13);
	set1.push(14);
	set1.push(15);
	set1.push(16);
	set1.push(17);
	System.out.println(set1.setSize());
	
	//System.out.println(set1.popAtIndex(2));
	System.out.println(set1.popAtIndex(1));
	}
		
}
