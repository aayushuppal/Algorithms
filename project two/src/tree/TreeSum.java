package tree;

/**
 * Created by hellsapphire on 11/4/2015.
 */
public class TreeSum {

    public static void main(String[] args) {
        MyBST bst = new MyBST();
        bst.add(5);
        bst.add(3);
        bst.add(4);
        bst.add(1);
        bst.add(2);
        printSums(bst.root, 0);
    }

    public static void printSums(TreeNode root, int currSum) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            currSum += root.val;
            System.out.println(currSum);
            return;
        }

        currSum += root.val;

        printSums(root.left, currSum);
        printSums(root.right, currSum);
    }
}

