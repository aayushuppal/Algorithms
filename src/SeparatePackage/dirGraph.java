package SeparatePackage;

import java.util.*;

public class dirGraph {
	int count =0;
	boolean flag = false;
	HashSet<Integer> hst = new HashSet<Integer>();	
	Node[] nodeList= new Node[5];
		
	public void addNode(int a){
		nodeList[count] = new Node(a);
		count++;
	}
	
	public boolean checkPath(Node a, Node b){
		
		if (a == null) return false;
	else {	
		hst.add(a.value);
			if (hst.contains(b.value)){
				flag = true;
			} 
			for(Node x:a.adjacent){
				if(!hst.contains(x.value)){
					checkPath(x,b);
				}
			}	
		return flag;
	}
	}
	
	
}
