package Tree;

import Tree.binarySearchTree.*;

public class CheckIsBST {

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
		binarySearchTree obj = new binarySearchTree();
		bst1.findNode(19).leftChild = obj.new Node(34, "name");
		System.out.println(isLimit(bst1.root, Integer.MIN_VALUE, Integer.MAX_VALUE));
		
	}

	public static boolean isLimit(Node root, int min, int max){
		
		if (root == null) return true;
		if (root.key >= max || root.key <= min){
			return false;	
		}
		if (root.key < max && root.key > min) {
			return (isLimit(root.leftChild,min,root.key) && isLimit(root.rightChild,root.key,max));
		} 
		
		return true;
	}
}
