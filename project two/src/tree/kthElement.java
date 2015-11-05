package tree;

/**
 * Created by hellsapphire on 10/29/2015.
 */
public class kthElement {

    public static void main(String[] args) {
        MyBST bst = new MyBST();
        bst.add(5);
        bst.add(3);
        bst.add(4);
        bst.add(1);
        bst.add(2);


        TreeNode k = findKthElement(bst.root, 3);


    }


    public static TreeNode findKthElement(TreeNode root, int k) {
        if (root == null) {
            return null;
        }

        IntWrap count = new IntWrap();
        countNodes(root, count);

        if (k == count.val + 1)
            return root;

        if (count.val >= k) {
            return findKthElement(root.left, k);
        } else {
            return findKthElement(root.right, k - count.val - 1);
        }
    }


    public static void countNodes(TreeNode root, IntWrap count) {
        if (root == null)
            return;

        count.val++;

        countNodes(root.left, count);
        countNodes(root.right, count);
    }
}

class IntWrap{
    int val;
    IntWrap(){
        val = 0;
    }
}
