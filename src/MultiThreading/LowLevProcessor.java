package MultiThreading;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * Created by hellsapphire on 10/24/2015.
 * wait notify
 * low level thread synchronization
 * producer consumer
 */
public class LowLevProcessor {
    private Queue<Integer> queue;
    private int maxCap;
    private Random rnd;
    private final Object lock = new Object();

    LowLevProcessor(int qSize) {
        queue = new LinkedList<Integer>();
        maxCap = qSize;
        rnd = new Random();
    }

    public void producer() throws InterruptedException {
        int val = 0;
        while (true) {
            synchronized (lock) {
                while (queue.size() == maxCap) {
                    lock.wait();
                }
                queue.add(val);
                System.out.println("producer added: " + val + " q size is: " + queue.size());
                val++;
                lock.notify();
            }
        }
    }

    public void consumer() throws InterruptedException {
        while (true) {
            synchronized (lock) {
                while (queue.size() == 0) {
                    lock.wait();
                }
                int value = queue.remove();
                System.out.println("consumer removed: " + value + " q size is: " + queue.size());
                lock.notify();
            }
            Thread.sleep(100);
        }
    }

}
