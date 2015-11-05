package interQ2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by hellsapphire on 9/27/2015.
 */
public class MedianStream {
    int counter;
    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(10, new MinHeapComparator());

    public static void main(String[] args) {
        MedianStream msr = new MedianStream();
        int[] inp = {1, 3, 7, 1, 2, 4, 3, 2, 1};
        for (int a : inp) {
            System.out.println(msr.MedianFinder(a));
        }
    }

    public float MedianFinder(int a) {
        float res = 0;

        if (counter < 2) {
            maxHeap.add(a);
            if (counter == 1) {
                minHeap.add(maxHeap.poll());
                res = (float) (maxHeap.peek() + minHeap.peek()) / 2;
            } else {
                res = maxHeap.peek();
            }
        } else {
            if (counter % 2 == 0) {
                if (a > minHeap.peek()) {
                    maxHeap.add(minHeap.poll());
                    minHeap.add(a);
                } else {
                    maxHeap.add(a);
                }
                res = maxHeap.peek();
            } else {
                if (a > minHeap.peek()) {
                    maxHeap.add(minHeap.poll());
                    minHeap.add(a);
                } else {
                    maxHeap.add(a);
                }
                minHeap.add(maxHeap.poll());
                res = (float) (maxHeap.peek() + minHeap.peek()) / 2;

            }
        }


        counter++;
        return res;

    }
}

class MinHeapComparator implements Comparator<Integer> {

    public int compare(Integer i, Integer j) {
        if (i < j) {
            return 1;
        } else if (i == j) {
            return 0;
        } else {
            return -1;
        }
    }
}