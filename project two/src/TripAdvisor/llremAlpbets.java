package TripAdvisor;

/**
 * Created by hellsapphire on 11/2/2015.
 */
public class llremAlpbets {

    public static void main(String[] args) {
        ListNode A = new ListNode(-1); // -1 denotes char
        ListNode head = A;
        head.next = new ListNode(1);
        head = head.next;
        head.next = new ListNode(2);
        head = head.next;
        head.next = new ListNode(-1);
        head = head.next;
        head.next = new ListNode(3);
        head = head.next;
        head.next = new ListNode(-1);

        ListNode fH = new ListNode();
        ListNode p = fH;

        ListNode hd = A;

        while (hd != null) {
            if (hd.val != -1) {
                p.next = hd;
                p = p.next;
            }
            hd = hd.next;

        }

        p.next = null;

        A = fH.next;
    }




}

