package MultiThreading;

/**
 * Created by hellsapphire on 10/24/2015.
 */
public class App {

    public static void main(String[] args) throws InterruptedException {
        final LowLevProcessor proc = new LowLevProcessor(10);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    proc.producer();
                } catch (InterruptedException e) {
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    proc.consumer();
                } catch (InterruptedException e) {
                }
            }
        });


        t1.start();
        t2.start();

        t1.join();
        t2.join();

        Thread.sleep(10000);
        System.exit(0);
    }
}
