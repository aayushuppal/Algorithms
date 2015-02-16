package Tree;

import Tree.binarySearchTree.Node;

public class GenTreeInPost {

	static int preIndex = 0;
	public static void main(String[] args) {
		int[] IO = {4,2,5,1,6,3};
		int[] PO = {1,2,4,5,3,6};
		
		binarySearchTree bst = new binarySearchTree();
		bst.root = GenTree(IO,PO,0,IO.length-1);
		System.out.println("checkpoint");
	}
	
	public static Node GenTree(int[] IO, int[] PO, int IStart, int IEnd){
		
		if (IStart > IEnd){	
			return null;
		}
		
		binarySearchTree obj = new binarySearchTree();
		Node tempNode = obj.new Node(PO[preIndex++]);
		
		if (IStart == IEnd){	
			return tempNode;
		}
		
		int IIndex = Search(IO,IStart,IEnd,tempNode.key);
		
		if (IIndex == -1){
			System.out.println("error!");
			return null;
		}
		
		tempNode.leftChild = GenTree(IO,PO,IStart,IIndex-1);
		tempNode.rightChild = GenTree(IO,PO,IIndex+1,IEnd);
		
		return tempNode;
	}
	
	public static int Search(int[] IO, int IStart, int IEnd, int data){
		for (int i=IStart; i<=IEnd; i++){
			if(IO[i] == data){
				return i;
			}
		}
		return -1;
	}
	
}
