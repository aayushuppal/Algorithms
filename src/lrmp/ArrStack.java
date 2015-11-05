package lrmp;

/**
 * Created by hellsapphire on 10/9/2015.
 * Array Stack implementation
 */
public class ArrStack {
    int[] data;
    int top;
    int maxIndex;

    public ArrStack(int cap) {
        data = new int[cap];
        top = -1;
        maxIndex = cap - 1;
    }

    public void push(int val) {
        if (top < maxIndex) {
            data[++top] = val;
        } else {
            throw new RuntimeException("capacity exceeded");
        }
    }

    public int size() {
        return top + 1;
    }

    public int pop() {
        if (top > -1) {
            int res = data[top];
            data[top] = -1;
            top--;
            return res;
        } else {
            throw new RuntimeException("stack empty");
        }
    }

    public static void main(String[] args) {
        tester();
    }

    public static void tester() {
        ArrStack ms = new ArrStack(6);
        ms.push(10);
        ms.push(11);
        ms.push(12);
        ms.push(14);
        ms.push(13);
        ms.push(15);

        System.out.println(ms.pop());
        System.out.println(ms.size());
    }
}
