package Graphs;
/*
 * BFS is basically an iterative algorithm > use a queue > update all adjacent and then 
 * run until queue empty.
 */
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
		n2.adjacent.add(n5);
		n3.adjacent.add(n5);
		n5.adjacent.add(n4);
		n4.adjacent.add(n1);
		
		HashSet<Node> hst = new HashSet<Node>();
		Queue<Node> qe = new LinkedList<Node>();
		RecursiveDFS(hst,n1);
		System.out.println("----");
		//BFS(hst,qe,n1);
		DFS(n1);
	}
	
	public static void BFS(HashSet<Node> hst,Queue<Node> qe,Node V){
		hst.add(V);	System.out.println(V.value);
		for (Node x:V.adjacent){
			hst.add(x);
			System.out.println(x.value);
			qe.add(x);
		}
		while(!qe.isEmpty()){
			Node z = qe.remove();
			for (Node x:z.adjacent){	
				if(!hst.contains(x)){	hst.add(x);	System.out.println(x.value); qe.add(x);	}
				
			}
		}
		
	}
	
	public static void DFS(Node start){
		HashSet<Node> Trav = new HashSet<Node>();
		Stack<Node> st = new Stack<Node>();
		
		System.out.println(start.value);
		Trav.add(start);
		
		for (Node x: start.adjacent){
			st.push(x);
		}
		
		while (!st.isEmpty()){
			Node z = st.pop();
			if(!Trav.contains(z)){
				System.out.println(z.value);
				Trav.add(z);
			}
			for (Node x: z.adjacent){
				if(!Trav.contains(x)){
					st.push(x);	
				}
			}
		}
		
	}

	public static void RecursiveDFS(HashSet<Node> hst,Node root){
		if (hst.contains(root)){	return;	}
		System.out.println(root.value);
		hst.add(root);
		for (Node x:root.adjacent){
			RecursiveDFS(hst,x);
		}
		
	}
}
