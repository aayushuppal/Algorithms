package bAsics;


/**
 * Created by hellsapphire on 10/10/2015.
 */
public class mergeLL {

    public static void main(String[] args){


        ListNode head = new ListNode(10);
        ListNode p = head;
        p.next = new ListNode(9);
        p = p.next;
        p.next = new ListNode(12);
        p = p.next;
        p.next = new ListNode(2);
        p = p.next;
        p.next = new ListNode(-9);
        p = p.next;
        p.next = new ListNode(22);

        ListNode x = mergeSort(head);
        System.out.println();
    }

    public static ListNode mergeSort(ListNode h){
        if (h == null || h.next == null){
            return h;
        }

        ListNode mid = midofLL(h);
        ListNode midNext = mid.next;
        mid.next = null;

        ListNode h1 = mergeSort(h);
        ListNode h2 = mergeSort(midNext);

        ListNode x = mergerOfSorted(h1, h2);
        return x;

    }

    public static ListNode mergerOfSorted(ListNode h1, ListNode h2){
        ListNode p1 = h1;
        ListNode p2 = h2;

        ListNode fH = new ListNode();
        ListNode p = fH;

        while (p1 != null && p2 !=null){
            if (p1.val <= p2.val){
                p.next =p1;
                p1 = p1.next;
            } else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }

        if (p1 != null){
            p.next = p1;
        } else if (p2 != null){
            p.next = p2;
        }

        return fH.next;
    }


    public static ListNode midofLL(ListNode h){
        ListNode slow = h;
        ListNode fast = h;

        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;

        /* code for actual mean value
        if (fast.next != null){
            return (slow.val + slow.next.val)/2;
        } else {
            return slow.val;
        }*/

    }


    static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
        }
        ListNode(){}
    }

}
