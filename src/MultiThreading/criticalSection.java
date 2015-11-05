package MultiThreading;

/**
 * Created by hellsapphire on 10/24/2015.
 */
public class criticalSection {
    private static int[] arr = new int[10];
    private static final Object lock = new Object();
    private static int val = 1;

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });
    }

    public static void critical() {
        synchronized (lock) {
            arr[0] = val;
            val++;
        }
    }


}
