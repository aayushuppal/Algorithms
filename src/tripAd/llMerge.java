package tripAd;

/**
 * Created by hellsapphire on 10/7/2015.
 */
public class llMerge {

    public static void main(String[] args) {
        ListNode h1 = new ListNode(10);
        ListNode h2 = new ListNode(11);

        ListNode h1t = h1;
        h1t.next = new ListNode(12);
        h1t = h1t.next;
        h1t.next = new ListNode(13);
        h1t = h1t.next;
        h1t.next = new ListNode(14);
        h1t = h1t.next;
        h1t.next = new ListNode(15);
        h1t = h1t.next;
        h1t.next = new ListNode(21);

        ListNode p = h1;
        p.next = null;

        ListNode h2t = h2;
        h2t.next = new ListNode(20);
        h2t = h2t.next;
        h2t.next = new ListNode(22);
        h2t = h2t.next;
        h2t.next = new ListNode(23);
        h2t = h2t.next;

        mergeLists(h1,h2);

    }

    public static ListNode mergeLists(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;

        ListNode fakeHead = new ListNode();
        ListNode p = fakeHead;

        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                p.next = p1;
                p1 = p1.next;
            } else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }

        if (p1 != null){
            p.next = p1;
        } else if (p2 != null) {
            p.next = p2;
        }

        return fakeHead.next;
    }


    static class ListNode {
        int val;
        ListNode next;

        ListNode(int v) {
            this.val = v;
        }

        ListNode() {

        }
    }
}
