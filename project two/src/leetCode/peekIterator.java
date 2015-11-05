package leetCode;

import java.util.*;

/**
 * Created by hellsapphire on 10/30/2015.
 */
public class peekIterator {

    public static void main(String[] args) {

        ArrayList<Integer> aL = new ArrayList<>();
        aL.add(1);
        aL.add(2);
        aL.add(3);
        aL.add(4);
        aL.add(5);


        PeekingIterator pitr = new PeekingIterator(aL.iterator());

        while (pitr.hasNext()) {
            System.out.println(pitr.next());
        }

        Scanner in = new Scanner(System.in);
        while (true) {
            String s = in.nextLine();

            if (s.equals("hn")) {
                System.out.println(pitr.hasNext());
            } else if (s.equals("n")) {
                System.out.println(pitr.next());
            } else if (s.equals("p")) {
                System.out.println(pitr.peek());
            }
        }


    }
}


// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
    Iterator<Integer> itr;
    Integer[] x;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.

        itr = iterator;
        x = new Integer[2];

        if (itr.hasNext()) {
            x[0] = itr.next();
        }

        if (itr.hasNext()) {
            x[1] = itr.next();
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return x[0];
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if (hasNext()) {
            int res = x[0];

            x[0] = x[1];

            if (itr.hasNext()) {
                x[1] = itr.next();
            } else {
                x[1] = null;
            }


            return res;
        } else {
            return null;
        }
    }

    @Override
    public boolean hasNext() {
        return x[0] != null;
    }

    @Override
    public void remove() {
    }
}