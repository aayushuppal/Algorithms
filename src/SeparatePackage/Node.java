package SeparatePackage;

import java.util.*;

public class Node {
	Object state;
	int value;
	ArrayList<Node> adjacent;
	
	Node(int a){
		this.adjacent = new ArrayList<Node>();
		this.value = a;
	}


}
