package tree;

import java.util.Iterator;
import java.util.Stack;

/**
 * Created by hellsapphire on 10/26/2015.
 *
 * In Order BST iterator implementation
 */
public class bstIter {

    public static void main(String[] args) {
        MyBST bst = new MyBST();
        bst.add(5);
        bst.add(3);
        bst.add(4);
        bst.add(1);
        bst.add(2);

        Iterator iter = new InOrderIterator(bst.root);

        while (iter.hasNext()) {
            System.out.println(((TreeNode) iter.next()).val);
        }

    }

}


class InOrderIterator implements Iterator<TreeNode> {
    private Stack<TreeNode> stk = new Stack<>();

    private void pushLeft(TreeNode root) {
        while (root != null) {
            stk.push(root);
            root = root.left;
        }
    }

    public InOrderIterator(TreeNode root) {
        pushLeft(root);
    }

    public boolean hasNext() {
        return !stk.isEmpty();
    }

    public TreeNode next() {
        if (hasNext()) {
            TreeNode res = stk.pop();
            pushLeft(res.right);
            return res;
        } else {
            return null;
        }
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }
}
