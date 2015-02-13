package Tree;

import java.util.ArrayList;

import Tree.binarySearchTree.Node;

public class NodesBetweenLimit {

	

	public static void main(String[] args) {
		binarySearchTree bst1 = new binarySearchTree();
		bst1.addNode(12, "name");
		bst1.addNode(7, "name");
		bst1.addNode(15, "name");
		bst1.addNode(5, "name");
		bst1.addNode(10, "name");
		bst1.addNode(4, "name");
		bst1.addNode(6, "name");
		bst1.addNode(9, "name");
		bst1.addNode(11, "name");
		bst1.addNode(14, "name");
		bst1.addNode(17, "name");
		bst1.addNode(16, "name");
		bst1.addNode(21, "name");
		bst1.addNode(19, "name");
		
		int a = Integer.MIN_VALUE;
		
		ArrayList<Integer> nodes = new ArrayList<Integer>();
		NodesLessThan(nodes,bst1.root,18);
		//FindNodesBetween(nodes, bst1.root,a,10); //includes nodes 10 and 16
		//nodes = PrintNodes(bst1,10,16); //includes nodes 5 and 19
		System.out.println(nodes);
	}
	
	public static void FindNodesBetween(ArrayList<Integer> nodes, Node root, int l, int h){
		
		if (root == null){	return;	}
		if (root.key > l ){
			FindNodesBetween(nodes, root.leftChild,l,h);
		}
		if (l<= root.key && h>=root.key){
			nodes.add(root.key);
		}
		if (root.key < h){
			FindNodesBetween(nodes, root.rightChild,l,h);
		}
	}
	
	public static ArrayList<Integer> PrintNodes(binarySearchTree t, int l, int h){
		
		ArrayList<Integer> a = new ArrayList<Integer>();
		ArrayList<Integer> b = new ArrayList<Integer>();
		ArrayList<Integer> c = new ArrayList<Integer>();
		a = NodesLessThan(t,l);
		b = NodesLessThan(t,h);
		// c = b-a;
		return c;
		
	}
	
	public static void NodesLessThan(ArrayList<Integer> nodes, Node root, int a){
		Node current = root;
		while(current != null && current.key != a ){
		 if (current.key <=a) {
				nodes.add(current.key);
				PutInListinOrderTraversal(nodes, current.leftChild);
				current = current.rightChild;
			} else{
				current = current.leftChild;
			}
		} if (current != null ) {	nodes.add(current.key);	}
		
	}
	
	public static void PutInListinOrderTraversal(ArrayList<Integer> x, Node nd){
		if (nd == null){	return;	}
		PutInListinOrderTraversal(x, nd.leftChild);
		x.add(nd.key);
		PutInListinOrderTraversal(x, nd.rightChild);
	}
}
