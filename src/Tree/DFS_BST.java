package Tree;

import java.util.HashSet;
import java.util.Stack;

import Tree.binarySearchTree.Node;

public class DFS_BST {

	
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
		
		HashSet<Node> hst = new HashSet<Node>();
		
		RecursiveDFS(hst, bst1.root);
		System.out.println("-----");
		IterativeDFS(bst1.root);
		
	}
	
	public static void RecursiveDFS(HashSet<Node> hst,Node root){
		if (root == null){	return;	}
		System.out.println(root.key);
		hst.add(root);
		if(root.leftChild != null) { RecursiveDFS(hst,root.leftChild); }
		if(root.rightChild != null) { RecursiveDFS(hst,root.rightChild); }
		
	}

	public static void IterativeDFS(Node root){
		HashSet<Node> travNodes = new HashSet<Node>(); 
		Stack<Node> st = new Stack<Node>();
		
		System.out.println(root.key);
		travNodes.add(root);
		
		if (root.rightChild != null){ 
			st.push(root.rightChild);	
			}
		if (root.leftChild != null){ 
			st.push(root.leftChild);		
			}
		
		while(!st.isEmpty()){
			Node c = st.pop();
			if(!travNodes.contains(c)){
				System.out.println(c.key);
				travNodes.add(c);
			}		
			if (c.rightChild != null && !travNodes.contains(c.rightChild)){ 
				st.add(c.rightChild);	
				}
			if (c.leftChild != null && !travNodes.contains(c.leftChild)){ 
				st.add(c.leftChild);		
				}
		}
		
	}
}
