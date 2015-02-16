package Tree;

import Tree.binarySearchTree.Node;

public class Mirror {
	
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
		
		//binarySearchTree bst2 = new binarySearchTree();
		//bst2.root = MirrorTree(bst1.root);
		InPlaceMirrorTree(bst1.root);
		System.out.println("asasas");
	}
	
	public static Node MirrorTree(Node root){
		if (root == null) return null;
		
		binarySearchTree obj = new binarySearchTree(); 
		Node newNode = obj.new Node();
		newNode.key = root.key;
		newNode.name = root.name;
		
		newNode.leftChild = MirrorTree(root.rightChild);
		newNode.rightChild = MirrorTree(root.leftChild);
		
		return newNode;
	}
	
	public static void InPlaceMirrorTree(Node root){
		if(root !=null){
			Node temp = root.leftChild;
			root.leftChild = root.rightChild;
			root.rightChild = temp;
			
			InPlaceMirrorTree(root.leftChild);
			InPlaceMirrorTree(root.rightChild);
		}
	}

}
