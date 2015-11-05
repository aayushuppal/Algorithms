package MultiThreading;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by hellsapphire on 10/24/2015.
 */
public class demo5Worker {
    private Random random = new Random();
    private List<Integer> list1 = new ArrayList<>();
    private List<Integer> list2 = new ArrayList<>();

    Object lock1 = new Object();
    Object lock2 = new Object();

    // the problem with using synchronized in method signature is it locks on only one common
    // intrinsic object i.e. stageOne and stageTwo both are locked on one object
    // so if one thread is locked on stageOne then another thread can't use stageTwo too as well
    // we can fix this by synchornizing on different dummy objects
    public void stageOne() {
        synchronized (lock1) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
            }

            list1.add(random.nextInt(100));
        }

    }

    public void stageTwo() {
        synchronized (lock2) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
            }

            list2.add(random.nextInt(100));
        }

    }

    public void process() {
        for (int i = 0; i < 1000; i++) {
            stageOne();
            stageTwo();
        }
    }

    public void main() {
        System.out.println("Starting...");
        long start = System.currentTimeMillis();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                process();
            }
        });


        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                process();
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
        }

        long end = System.currentTimeMillis();
        System.out.println("time taken:" + (end - start));
        System.out.println("list1:" + list1.size() + "; list2: " + list2.size());
    }

}
