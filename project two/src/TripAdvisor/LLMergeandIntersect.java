package TripAdvisor;

/**
 * Created by hellsapphire on 11/2/2015.
 */

public class LLMergeandIntersect {

    public static void main(String[] args) {
        ListNode A = new ListNode(5);
        ListNode head = A;
        head.next = new ListNode(1);
        head = head.next;
        head.next = new ListNode(2);
        head = head.next;
        head.next = new ListNode(1);
        head = head.next;
        head.next = new ListNode(3);

        ListNode B = new ListNode(2);
        head = B;
        head.next = new ListNode(3);
        head = head.next;
        head.next = new ListNode(5);
        head = head.next;
        head.next = new ListNode(3);
        head = head.next;
        head.next = new ListNode(7);
        head = head.next;
        head.next = new ListNode(9);

        ListNode res = interSect(A, B);
    }

    public static ListNode sort(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode midNext = getMidNext(head);

        ListNode l = sort(head);
        ListNode r = sort(midNext);

        return merge(l, r);
    }

    private static ListNode getMidNext(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode res = slow.next;
        slow.next = null;
        return res;
    }

    private static ListNode merge(ListNode l, ListNode r) {
        ListNode fH = new ListNode();
        ListNode p = fH;

        while (l != null && r != null) {
            if (l.val <= r.val) {
                p.next = l;
                l = l.next;
            } else {
                p.next = r;
                r = r.next;
            }
            p = p.next;
        }

        if (l != null) {
            p.next = l;
        }

        if (r != null) {
            p.next = r;
        }

        return fH.next;
    }

    private static ListNode interSect(ListNode A, ListNode B) {
        A = sort(A);
        B = sort(B);

        ListNode fH = new ListNode();
        ListNode p = fH;

        ListNode h1 = A;
        ListNode h2 = B;

        while (h1 != null && h2 != null) {

            while (h2.val <= h1.val) {

                if (h2.val == h1.val) {
                    p.next = h1;
                    p = p.next;
                    ListNode temp = h2;
                    while (temp != null && temp.val == h2.val) {
                        temp = temp.next;
                    }
                    h2 = temp;
                } else {
                    h2 = h2.next;
                }

            }

            ListNode temp = h1;
            while (temp != null && temp.val == h1.val) {
                temp = temp.next;
            }
            h1 = temp;
        }

        p.next = null;


        return fH.next;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int a) {
        val = a;
    }

    ListNode() {
    }
}