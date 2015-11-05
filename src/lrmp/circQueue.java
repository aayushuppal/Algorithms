package lrmp;

/**
 * Created by hellsapphire on 10/9/2015.
 */
public class circQueue {
    int[] data;
    int first;
    int last;
    int currCap;
    int capacity;

    public circQueue(int cap) {
        this.capacity = cap;
        data = new int[cap];
        this.first = -1;
        this.last = -1;
        this.currCap = 0;
    }

    public void enqueue(int val) {
        if (first == -1) {
            first++;
        }

        if (currCap < capacity) {
            last = convertIndex(++last);
            data[last] = val;
        } else {
            throw new RuntimeException("out of capacity");
        }

        currCap++;
    }

    public int dequeue() {
        if (currCap > 0) {
            int res = data[first];
            data[first] = -1;
            first = convertIndex(++first);
            currCap--;
            return res;
        } else {
            throw new RuntimeException("empty queue");
        }

    }

    private int convertIndex(int a){
        return a%capacity;
    }

    public static void main(String[] args) {
        tester();
    }

    public static void tester(){
        circQueue cq = new circQueue(3);
        cq.enqueue(10);
        cq.enqueue(11);
        cq.enqueue(12);


        System.out.println(cq.dequeue());
        System.out.println(cq.dequeue());
        System.out.println(cq.dequeue());
        cq.enqueue(11);
        System.out.println();
    }

}
