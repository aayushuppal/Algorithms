
package Graphs;

import java.util.*;

public class dirGraph {
	
	public class Node{
		int value;
		ArrayList<Node> adjacent;
		
		Node(int a){
			adjacent = new ArrayList<dirGraph.Node>();
			this.value = a;
		}
	}
	
	public static void main(String[] args) {
		dirGraph dgp = new dirGraph();
		Node n1 = dgp.new Node(1);
		Node n2 = dgp.new Node(2);
		Node n3 = dgp.new Node(3);
		Node n4 = dgp.new Node(4);
		Node n5 = dgp.new Node(5);
		
		n1.adjacent.add(n2);
		n2.adjacent.add(n3);
		n2.adjacent.add(n4);
		n3.adjacent.add(n5);
		n5.adjacent.add(n4);
		
	}
	

}
