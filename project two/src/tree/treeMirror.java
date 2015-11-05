package tree;

/**
 * Created by hellsapphire on 10/26/2015.
 *
 * mirror a binary tree
 */
public class treeMirror {

    public static void main(String[] args) {
        MyBST bst = new MyBST();
        bst.add(5);
        bst.add(3);
        bst.add(4);
        bst.add(1);
        bst.add(2);

        mirror(bst.root);

        System.out.println();
    }


    public static void mirror(TreeNode root) {
        if (root == null) {
            return;
        }

        mirror(root.left);
        mirror(root.right);

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

}