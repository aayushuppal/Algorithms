package uncategorised;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class PriQue {

    public static void main(String[] args) {
	PQCustom pcs = new PQCustom();
	PriorityQueue<Integer> pq1 = new PriorityQueue<Integer>(pcs);
	// int[] aa = { 1, 12, 3, 4, 6, 8, 2, 9, 1 };
	Integer x = new Integer(12);
	Integer z = new Integer(14);
	pq1.offer(x);
	pq1.offer(z);
	/*
	 * for (Integer y : aa) { pq1.offer(y); }
	 */
	BlockingQueue bq = new ArrayBlockingQueue(1000);
	while (pq1.peek() != null) {
	    System.out.print(pq1.poll() + " ");
	}

    }

}

class PQCustom implements Comparator<Integer> {
    /*
     * public setPriorityVal(Airplane a) { if (a.isPassenger) { if (a.isLarge) {
     * return 4; } return 3; } else { if (a.isLarge) { return 2; } return 1; } }
     */

    @Override
    public int compare(Integer arg0, Integer arg1) {
	return 0;
	// return arg1 - arg0 == 0 ? 1 : arg1 - arg0;
    }
}
