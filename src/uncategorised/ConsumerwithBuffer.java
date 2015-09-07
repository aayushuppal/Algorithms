package uncategorised;

import java.util.Random;

public class ConsumerwithBuffer extends Thread {
    private Producer ProdThread;

    public ConsumerwithBuffer(Producer prod) {
	this.ProdThread = prod;
    }

    public void run() {
	try {
	    while (true) {
		System.out.println(ProdThread.get());
	    }
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}

    }

    public static void main() {
	Producer prod = new Producer(10);
	prod.start();
	new ConsumerwithBuffer(prod).start();
    }

}

class Producer extends Thread {
    private int MAX;
    private int[] buffer;
    private int index;
    private Random gen;

    public Producer(int max) {
	this.MAX = max;
	this.buffer = new int[max];
	this.index = 0;
	this.gen = new Random();
    }

    public void run() {
	try {
	    put();
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}
    }

    public synchronized void put() throws InterruptedException {
	while (index == MAX) {
	    wait();
	}
	buffer[index] = gen.nextInt(10);
	index++;
	notifyAll();
    }

    public synchronized int get() throws InterruptedException {
	notifyAll();
	while (index <= 0) {
	    wait();
	}
	index--;
	return buffer[index];
    }

}
