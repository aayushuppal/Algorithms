package TripAdvisor;

/**
 * Created by hellsapphire on 11/3/2015.
 */
public class revLLII {

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

        ListNode r = reverseBetween(head, 2, 4);

    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode M_1 = null;
        ListNode M = null;
        ListNode N = null;

        int i = 0;
        ListNode p = head;

        while (p != null && i <= n) {
            i++;
            if (i == m - 1) {
                M_1 = p;
            } else if (i == m) {
                M = p;
            } else if (i == n) {
                N = p;
            }

            p = p.next;
        }

        M_1.next = null;
        ListNode two = M;
        ListNode three = N.next;
        N.next = null;

        two = reverse(two);
        ListNode twoEnd = two;

        while (twoEnd.next != null) {
            twoEnd = twoEnd.next;
        }

        M_1.next = two;
        twoEnd.next = three;
        return head;
    }

    public static ListNode reverse(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode res = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return res;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int a) {
            val = a;
        }
    }
}

