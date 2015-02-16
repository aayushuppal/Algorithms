package Tree;

import Tree.binarySearchTree.*;

public class BST2DLL {

	
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
		
		Node ll = ConvertB2D(bst1.root);
		while (ll.leftChild != null){
			ll = ll.leftChild;
		}
		while(ll != null){
			System.out.printf("%d > ",ll.key);
			ll = ll.rightChild;
		}
		System.out.println("\ncheckpoint");
	}
	
	public static Node ConvertB2D(Node root){
		if (root == null){
			return root;
		}
		if (root.leftChild != null){
			Node left  = ConvertB2D(root.leftChild); 
			left = findMax(left);
			left.rightChild = root;
			root.leftChild = left;
		}
		if (root.rightChild != null){
			Node right  = ConvertB2D(root.rightChild); 
			right = findMin(right);
			right.leftChild = root;
			root.rightChild = right;
		}
		return root;
	}
	
	public static Node findMax(Node n){
		while (n.rightChild != null){
			n = n.rightChild;
		}
		return n;
	}
	public static Node findMin(Node n){
		while (n.leftChild != null){
			n = n.leftChild;
		}
		return n;
	}

}
