package bAsics.mathWorks;

import java.util.Stack;

/**
 * Created by hellsapphire on 10/17/2015.
 * Queue using stack mathworks
 */
public class queueFromStack<K> {
    private Stack<K>[] stArr;

    public queueFromStack() {
        stArr = new Stack[2];
        stArr[0] = new Stack<K>();
        stArr[1] = new Stack<K>();
    }

    public void enqueue(K val) {
        stArr[0].push(val);
    }

    public K dequeue() {
        if (stArr[1].isEmpty()) {
            while (!stArr[0].isEmpty()) {
                stArr[1].push(stArr[0].pop());
            }
        }
        return stArr[1].pop();
    }

    public static void main(String[] args) {
        queueFromStack<Integer> q1 = new queueFromStack<>();
        q1.enqueue(1);
        q1.enqueue(2);
        q1.enqueue(3);
        q1.enqueue(4);
        q1.enqueue(5);

        System.out.println(q1.dequeue());
        System.out.println(q1.dequeue());
        System.out.println(q1.dequeue());
        q1.enqueue(6);
        System.out.println(q1.dequeue());
        System.out.println(q1.dequeue());
        System.out.println(q1.dequeue());
    }
}
