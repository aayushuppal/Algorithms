package Tree;
/* basically we need to find height from a node and that we do by setting boundary case at null by returning 0 height whilst for every other we add 1 and sum the max of heights of that nodes left and right nodes found recursively.
 */

import Tree.binarySearchTree.*;

public class CheckBalancedBST {

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
		
		System.out.println(isBalanced(bst1.root));

	}
	
	public static boolean isBalanced(Node root){
		if (root == null) return true;
		int lh = height(root.leftChild);
		int rh = height(root.rightChild);
		
		if (Math.abs(lh-rh)<=1 && isBalanced(root.leftChild) && isBalanced(root.rightChild)){
			return true;
			}
		return false;
		}
	
	public static int height(Node nd){
		if (nd== null) return 0;
		return 1+Math.max(height(nd.leftChild),height(nd.rightChild) );
	}
	
	
	
}
