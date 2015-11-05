package tree;

/**
 * Created by hellsapphire on 10/26/2015.
 */
public class MyBST {
    TreeNode root;

    public MyBST() {
    }

    public void add(int a) {
        TreeNode newNode = new TreeNode(a);
        if (root == null) {
            root = newNode;
        } else {
            TreeNode pointer = root;

            while (true) {
                if (pointer.val > a) {
                    if (pointer.left == null) {
                        pointer.left = newNode;
                        break;
                    }
                    pointer = pointer.left;
                } else {
                    if (pointer.right == null) {
                        pointer.right = newNode;
                        break;
                    }
                    pointer = pointer.right;
                }
            }
        }
    }
}

class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode(int a) {
        val = a;
    }
}
