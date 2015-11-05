package bAsics;

/**
 * Created by hellsapphire on 10/15/2015.
 * Sorted linked list to BST
 * Zenefits
 */
public class SortedListToBST {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode p = head;
        p.next = new ListNode(2);
        p = p.next;
        p.next = new ListNode(3);
        p = p.next;
        p.next = new ListNode(4);
        p = p.next;
        p.next = new ListNode(5);
        p = p.next;

        TreeNode root = ListToBST(head);
    }

    public static TreeNode ListToBST(ListNode head) {
        if (head == null) {
            return null;
        }

        NodeWrap tmp = splitter(head);
        TreeNode root = new TreeNode(tmp.mid.val);
        root.left = ListToBST(tmp.left);
        root.right = ListToBST(tmp.right);

        return root;
    }

    private static NodeWrap splitter(ListNode head) {
        NodeWrap res = new NodeWrap();
        if (head.next == null) {
            res.left = null;
            res.mid = head;
            res.right = null;
            return res;
        }

        if (head.next.next == null) {
            res.left = null;
            res.mid = head;
            res.right = head.next;
            return res;
        }

        ListNode slow = head;
        ListNode prevSlow = slow;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            prevSlow = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prevSlow.next = null;
        res.left = head;
        res.mid = slow;
        res.right = slow.next;
        return res;
    }
}

class NodeWrap {
    ListNode left;
    ListNode mid;
    ListNode right;
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int v) {
        this.val = v;
        next = null;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int v) {
        this.val = v;
        left = null;
        right = null;
    }
}