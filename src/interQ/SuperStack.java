package interQ;

/**
 * Created by hellsapphire on 9/23/2015.
 */
public class SuperStack<T> {
    private StackNode top;
    private StackNode bottom;
    private int currentCapacity;

    SuperStack() {
        top = null;
        bottom = null;
        currentCapacity = 0;
    }

    public void push(T val) {
        StackNode temp = new StackNode(val);
        if (top == null) {
            top = temp;
            bottom = top;
            currentCapacity++;
            return;
        }
        temp.below = top;
        top.above = temp;
        top = top.above;
        currentCapacity++;
        return;
    }

    public T pop() {
        if (currentCapacity > 1) {
            T res = (T) top.val;
            top = top.below;
            top.above = null;
            currentCapacity--;
            return res;
        } else if (currentCapacity == 1){
            T res = (T) top.val;
            top = null;
            bottom = null;
            currentCapacity--;
            return res;
        }
        else {
            return null;
        }
    }

    static class StackNode<T> {
        T val;
        StackNode above;
        StackNode below;

        StackNode() {
        }

        StackNode(T input) {
            this.val = input;
        }

    }

    public static void main(String[] args){
        SuperStack<Integer> sStack = new SuperStack<Integer>();
        sStack.push(10);
        sStack.push(11);
        sStack.push(12);
        sStack.push(13);
        sStack.push(14);
        System.out.println(sStack.pop());
        System.out.println(sStack.pop());
        System.out.println(sStack.pop());
        System.out.println(sStack.pop());
        System.out.println(sStack.pop());
        System.out.println(sStack.pop());
    }
}
