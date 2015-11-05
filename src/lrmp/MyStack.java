package lrmp;

/**
 * Created by hellsapphire on 10/9/2015.
 */
public class MyStack {
    private int currCap;
    private Node top;

    MyStack() {
        this.currCap = 0;
        this.top = null;
    }

    public void push(int val) {
        if (top == null) {
            top = new Node(val);
            top.maxVal = val;
        } else {
            Node temp = new Node(val);
            temp.maxVal = Math.max(val, top.maxVal);
            temp.below = top;
            top = temp;
        }
        currCap++;
    }

    public int getMax(){
        return top.maxVal;
    }

    public int pop(){
        int res = top.val;
        top = top.below;
        currCap--;
        return res;
    }

    public int size(){
        return currCap;
    }

    public int peek(){
        return top.val;
    }

    private class Node {
        int val;
        Node below;
        int maxVal;

        Node(int a) {
            this.val = a;
        }
    }

    public static void main(String[] args) {
        tester();
    }

    public static void tester() {
        MyStack ms = new MyStack();
        ms.push(10);
        ms.push(11);
        ms.push(12);
        ms.push(14);
        ms.push(13);
        ms.push(15);

        System.out.println(ms.pop());
        System.out.println(ms.getMax());
        System.out.println(ms.size());
        System.out.println(ms.peek());
    }
}
