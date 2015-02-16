package Tree;

import java.util.HashSet;
import java.util.Queue;
import java.util.LinkedList;
import Tree.binarySearchTree.*;

public class BFS_BST {

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
		
		HashSet<Node> hsd = new HashSet<Node>();
		
		hsd = BFS(bst1.root);
		System.out.println("-----");
		
	}
	
	public static HashSet<Node> BFS(Node root){
		HashSet<Node> hst = new HashSet<Node>();
		
		Queue<Node> qe = new LinkedList<Node>();
		System.out.println(root.key);
		hst.add(root);
		
		if (root.leftChild != null) {	
		System.out.println(root.leftChild.key); 
		hst.add(root.leftChild); 
		qe.add(root.leftChild);	
		}
		if (root.rightChild != null){	
			hst.add(root.rightChild); 
			System.out.println(root.rightChild.key); 
			qe.add(root.rightChild);	
			}
		
		while(!qe.isEmpty()){
			Node z = qe.remove();
			if (z.leftChild != null && !hst.contains(z.leftChild)){	
				hst.add(z.leftChild); 
				System.out.println(z.leftChild.key); 
				qe.add(z.leftChild);	
				}
			if (z.rightChild != null && !hst.contains(z.rightChild)){	
			System.out.println(z.rightChild.key);
			hst.add(z.rightChild); 
			qe.add(z.rightChild);	
			}
		}
		
		return hst;
	}

}
