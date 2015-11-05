package Cask;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by hellsapphire on 11/3/2015.
 */
public class nonRepIterator {

    public static void main(String[] args) {
        Integer[] A = {1, 1, 2, 3, 1, 1, 4, 4, 5};
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(A));

        myIter itr = new myIter(list.iterator());

        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
}

class myIter implements Iterator<Integer> {
    Iterator<Integer> itr;
    Integer prev;
    Integer nextVal;

    public myIter(Iterator<Integer> iterator) {
        itr = iterator;
        prev = null;
        nextVal = null;
    }


    public Integer next() {
        if (nextVal != null) {
            int temp = nextVal;
            nextVal = null;
            return temp;
        } else {
            hasNext();
            int temp = nextVal;
            nextVal = null;
            return temp;
        }
    }

    public boolean hasNext() {

        while (true) {

            if (itr.hasNext()) {
                nextVal = itr.next();
            } else {
                nextVal = null;
            }

            if (nextVal == null && prev == null)
                break;

            if (nextVal != prev) {
                prev = nextVal;
                break;
            }
        }

        return nextVal != null;
    }


    public void remove() {
    }
}
