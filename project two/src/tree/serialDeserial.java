package tree;

import java.util.*;

/**
 * Created by hellsapphire on 10/27/2015.
 */
public class serialDeserial {

    public static void main(String[] args) {
        MyBST bst = new MyBST();
        bst.add(5);
        bst.add(3);
        bst.add(4);
        bst.add(1);
        bst.add(2);

        //System.out.println(serialize(bst.root));

        TreeNode rt = deserialize(serialize(null));
    }

    public static String serialize(TreeNode root) {
        if (root == null) {
            return "[]";
        }
        String output = "[" + root.val;

        ArrayList<TreeNode> children = new ArrayList<>();

        children.add(root);

        while (children.size() > 0) {
            ArrayList<TreeNode> parent = children;
            children = new ArrayList<>();

            for (TreeNode p : parent) {

                if (p.left == null) {
                    output = output + "," + "#";
                } else {
                    output = output + "," + p.left.val;
                    children.add(p.left);
                }

                if (p.right == null) {
                    output = output + "," + "#";
                } else {
                    output = output + "," + p.right.val;
                    children.add(p.right);
                }

            }

        }

        return output + "]";
    }


    public static TreeNode deserialize(String data) {
        data = data.substring(1, data.length() - 1);
        String[] sArr = data.split(",");

        if (sArr[0].equals("")) {
            return null;
        }

        int i = 0;
        Queue<TreeNode> cQ = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(sArr[i++]));
        cQ.add(root);

        while (!cQ.isEmpty()) {
            TreeNode temp = cQ.poll();

            String l = sArr[i++];
            String r = sArr[i++];

            if (!l.equals("#")) {
                TreeNode left = new TreeNode(Integer.parseInt(l));
                temp.left = left;
                cQ.add(left);
            }
            if (!r.equals("#")) {
                TreeNode right = new TreeNode(Integer.parseInt(r));
                temp.right = right;
                cQ.add(right);
            }
        }

        return root;
    }
}
