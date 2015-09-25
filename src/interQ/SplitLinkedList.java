package interQ;


/**
 * Created by hellsapphire on 9/22/2015.
 */
public class SplitLinkedList {

    public static void main(String[] args) {
        MyLL ll = new MyLL();
        ll.add(10);
        ll.add(12);
        ll.add(14);
        ll.add(13);
        ll.add(11);

        llNode res = partitionBy(ll.head, 15);
    }


    public static llNode partitionByUsingLL(llNode head, int X) {
        MyLL A = new MyLL();
        MyLL B = new MyLL();

        while (head != null) {
            if (head.val < X) {
                A.add(head.val);
            } else {
                B.add(head.val);
            }
            head = head.next;
        }

        llNode Ahead = A.head;

        while (Ahead.next != null) {
            Ahead = Ahead.next;
        }

        Ahead.next = B.head;
        return A.head;
    }

    public static llNode partitionBy(llNode node, int X) {
        llNode Astart = null;
        llNode Aend = null;
        llNode Bstart = null;
        llNode Bend = null;

        while (node != null) {
            if (node.val < X) {
                if (Astart == null) {
                    Astart = node;
                    Aend = Astart;
                } else {
                    Aend.next = node;
                    Aend = Aend.next;
                }
            } else {
                if (Bstart == null) {
                    Bstart = node;
                    Bend = Bstart;
                } else {
                    Bend.next = node;
                    Bend = Bend.next;
                }
            }
            node = node.next;
        }



        if (Astart == null) {
            return Bstart;
        }
        if (Bend != null){
            Bend.next = null;
        }
        Aend.next = Bstart;
        return Astart;
    }
}

class MyLL {
    llNode head;
    private llNode current;

    MyLL() {
        head = null;
    }

    public void add(int val) {
        if (head == null) {
            head = new llNode(val);
            current = head;
            return;
        }
        current.next = new llNode(val);
        current = current.next;
    }

}

class llNode {
    int val;
    llNode next;

    llNode(int val) {
        this.val = val;
    }
}