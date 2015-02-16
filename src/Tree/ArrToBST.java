package Tree;

import Tree.binarySearchTree.*;

public class ArrToBST {

	public static void main(String[] args) {
		int[] IA = {1,2,3,4,5,6,7};
		binarySearchTree bst = new binarySearchTree();
		bst.root = new ArrToBST().GenTree(IA,0,IA.length-1);
		System.out.println("checkpoint");
	}
	
	public Node GenTree(int[] IA, int IStart, int IEnd){
		if (IStart > IEnd){ 
			return null; 
			}
		binarySearchTree obj = new binarySearchTree();
		Node tempNode = obj.new Node(IA[(IStart+IEnd)/2]);
		if (IStart == IEnd){ 	
			return tempNode;	
			}
		int IIndex = (IStart+IEnd)/2;
		tempNode.leftChild = GenTree(IA,IStart,IIndex-1);
		tempNode.rightChild = GenTree(IA,IIndex+1,IEnd);
		
		return tempNode;
	}
	
}

