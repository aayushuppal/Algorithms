package tree;

/**
 * Created by hellsapphire on 10/26/2015.
 * <p/>
 * binary tree to sorted doubly linked list in place / circular doubly linked list
 */
public class bst2dll {

    public static void main(String[] args) {
        MyBST bst = new MyBST();
        bst.add(5);
        bst.add(3);
        bst.add(4);
        bst.add(1);
        bst.add(2);

        TreeNode head = bstToDll(bst.root);
        System.out.println(head.val);
    }


    public static TreeNode bstToDll(TreeNode root) {
        NodePair result = new NodePair();
        bstToDll(root, result);

        // make circular
        result.head.left = result.tail;
        result.tail.right = result.head;

        return result.head;
    }

    public static void bstToDll(TreeNode root, NodePair result) {

        if (root == null)
            return;

        bstToDll(root.left, result);   // go left

        root.left = result.tail;
        if (result.head == null) {
            result.head = root;
        } else {
            result.tail.right = root;
        }


        TreeNode right = root.right;
        result.tail = root;
        root.right = null;

        bstToDll(right, result);  //go right

    }


}

class NodePair {
    TreeNode head;
    TreeNode tail;
}
