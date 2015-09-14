package practice;

import java.util.LinkedList;

public class CheckBstBalanced {

    public static void main(String[] args) {
	BST b1 = new BST();

	b1.Add(8);
	b1.Add(6);
	b1.Add(7);
	b1.Add(9);
	b1.Add(5);
	System.out.println(Node.getHeight(b1.root));

	LinkedList<Integer> yy = new LinkedList<Integer>();
	for (Integer x : yy) {

	}
    }
}

// ----------

/**
 * 
 * Node definition for BST
 *
 */
class Node {
    int val;
    Node left;
    Node right;
    int height;

    Node(int a) {
	this.val = a;
    }

    /**
     * 
     * return height of node in a tree
     */
    public static int getHeight(Node x) {
	if (x == null) {
	    return 0;
	}
	x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
	return x.height;
    }
}

/**
 * 
 * class for Binary Search Tree
 *
 */
class BST {
    Node root;

    BST() {
    }

    public void Add(int a) {
	Node in = new Node(a);
	if (root == null) {
	    root = in;
	    return;
	}

	Node current = root;
	while (true) {
	    if (in.val < current.val) {
		if (current.left != null) {
		    current = current.left;
		} else {
		    current.left = in;
		    return;
		}
	    } else {
		if (current.right != null) {
		    current = current.right;
		} else {
		    current.right = in;
		    return;
		}
	    }
	}

    }

    public boolean isBalanced() {
	return recursiveBalanceCheck(root);
    }

    public boolean recursiveBalanceCheck(Node root) {
	if (root == null) {
	    return true;
	}
	return Math.abs(Node.getHeight(root.left) - Node.getHeight(root.right)) <= 1 ? true
		: false;

    }
}