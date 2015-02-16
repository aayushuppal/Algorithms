package Tree;
/* The basic concept being traverse to both nodes and then reverse traversal then display the first common node
 * The major challenge comes in Binary tree for traversal from root to a node, implemented in getPath function
 * we do this by return type bool then return false in case hit null node 
 * otherwise add the node and if we realise that the path does not contain the node remove it and return false
 * else return true
*/

import java.util.ArrayList;

import Tree.binarySearchTree.*;

public class BinaryTreeLCA {

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
		
		// consider this bst as a bt and don't use the comaprison between left and right parameter
		System.out.println(FindLCA(bst1.root,4,11));
	}
	
	public static int FindLCA(Node root,int a, int b){
		ArrayList<Integer> aPath = new ArrayList<Integer>();
		ArrayList<Integer> bPath = new ArrayList<Integer>();
		getPath(aPath,root,a);
		getPath(bPath,root,b);
		int i = aPath.size()-1;
		int j = bPath.size()-1;
		while(i>=0 && j>=0 && aPath.get(i)!=bPath.get(j)){
			i--;
			j--;
		}
		if (i >=0 && j>=0) {	return aPath.get(i);	}
		return -1;
	}
	
	public static boolean getPath(ArrayList<Integer> path, Node root, int k){
		if (root == null) return false;
		path.add(root.key);
		if (root.key == k){	return true; }
		
		if (root.leftChild != null && getPath(path,root.leftChild,k) || 
			root.rightChild != null && getPath(path,root.rightChild,k)){
			return true;
		}
		
		path.remove(path.size()-1);
		return false;
	}
	
}
