package uncategorised;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ProducerConsumer {

    public static void main(String[] args) {
	CustomPQ pcs = CustomPQ.getInstance();
	PriorityQueue pq = new PriorityQueue(pcs);
	int size = 10;
	Thread adderThread = new Thread(new Adder(pq, size), "Adder");
	Thread removerThread = new Thread(new Remover(pq, size, adderThread),
		"Remover");

	adderThread.start();
	removerThread.start();

    }
}

class CustomPQ implements Comparator<Integer> {
    private static CustomPQ instance = null;

    private CustomPQ() {
    }

    public static CustomPQ getInstance() {
	if (instance == null) {
	    instance = new CustomPQ();
	}
	return instance;
    }

    @Override
    public int compare(Integer existing, Integer incoming) {
	return incoming - existing;
    }

}

class Adder implements Runnable {
    private final PriorityQueue<Integer> pq;
    private final int SIZE;

    public Adder(PriorityQueue<Integer> q, int size) {
	this.pq = q;
	this.SIZE = size;
    }

    @Override
    public void run() {
	// TODO Auto-generated method stub

    }

}

class Remover implements Runnable {
    private final PriorityQueue<Integer> pq;
    private final int SIZE;
    private final Thread AdderThread;

    public Remover(PriorityQueue<Integer> q, int size, Thread adder) {
	this.pq = q;
	this.SIZE = size;
	this.AdderThread = adder;
    }

    @Override
    public void run() {
	// TODO Auto-generated method stub

    }

}