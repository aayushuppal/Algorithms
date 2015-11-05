package MultiThreading;

/**
 * Created by hellsapphire on 10/24/2015.
 * problem with interleaving of threads
 * basic synchronization
 */
public class demo4App {

    private int count = 0;

    // synchronized is an intrinsic block
    // synchronized ensures volatile behavior too
    public synchronized void increment() {
        count++;
    }

    public static void main(String[] args) {
        demo4App app = new demo4App();
        app.doWork();
    }

    public void doWork() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    increment();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    increment();
                }
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            // join method waits till execution
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(count);
    }
}