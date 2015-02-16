package Tree;
/* The basic idea being check if root < l AND root < h then shift left OR root > l AND root > h then shift right 
 * if encounter a point where root falls between the two, return it.
 * Checking for a BST here.
*/
import Tree.binarySearchTree.*;

public class LeastCommonAncestor {

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

		System.out.println(FindLeastCommonAncestor(bst1.root,9,11));
	}

	public static int FindLeastCommonAncestor(Node root, int l, int h){
		while(root!=null){
			if (root.key < l && root.key < h)	{	root = root.rightChild;	}
			else if (root.key > l && root.key > h)	{	root = root.leftChild;	}
			else break;
		}
		return root.key;
	}
}
