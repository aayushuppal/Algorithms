package Test;

/**
 * Created by hellsapphire on 10/29/2015.
 */
public class syncTest {
    int val;
    static Object l1 = new Object();
    static Object l2 = new Object();

    syncTest() {
        val = 0;
    }


    public synchronized void methodA() {
        //synchronized (this) {
        try {
            Thread.sleep(1000);

            for (int i = 0; i < 10; i++) {
                System.out.print("A");
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
        }
        //}
    }

    public synchronized void methodB() {
        //synchronized (this) {
        try {
            Thread.sleep(1000);

            for (int i = 0; i < 10; i++) {
                System.out.print("B");
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
        }
        //}
    }


    public static void main(String[] args) {

        long s = System.currentTimeMillis();
        final syncTest obj = new syncTest();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                obj.methodA();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                obj.methodB();
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
        }

        long e = System.currentTimeMillis();
        System.out.println((e - s));

    }
}