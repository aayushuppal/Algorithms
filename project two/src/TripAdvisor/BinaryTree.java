package TripAdvisor;

import sun.reflect.generics.tree.Tree;

/**
 * Created by hellsapphire on 11/2/2015.
 */
public class BinaryTree {
    TreeNode root;

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.root = new TreeNode(8);
        bt.root.left = new TreeNode(7);
        bt.root.right = new TreeNode(4);
        TreeNode l = bt.root.left;
        l.left = new TreeNode(3);
        l.right = new TreeNode(1);
        TreeNode r = bt.root.right;
        r.left = new TreeNode(5);
        r.right = new TreeNode(9);

        TreeNode min = getMin(bt.root);

        bubble(bt.root, min);

    }

    public static TreeNode bubble(TreeNode root, TreeNode Min) {
        return null;
    }

    public static TreeNode getMin(TreeNode root) {
        if (root == null || (root.left == null && root.right == null))
            return root;
        return getMinUtil(root);
    }

    public static TreeNode getMinUtil(TreeNode root) {
        if (root == null)
            return new TreeNode(Integer.MAX_VALUE);

        TreeNode res = root;
        TreeNode A = getMinUtil(root.left);
        TreeNode B = getMinUtil(root.right);

        if (A.val < res.val)
            res = A;
        if (B.val < res.val)
            res = B;

        return res;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int a) {
        val = a;
    }
}