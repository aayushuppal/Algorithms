package MultiThreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by hellsapphire on 10/24/2015.
 *
 * Thread pool example using executor service
 */
public class executorExmpl {

    public static void main(String[] args) {
        ExecutorService ext = Executors.newFixedThreadPool(2);
        for (int i = 1; i <= 5; i++) {
            ext.submit(new Process(i));
        }

        ext.shutdown();

        try {
            ext.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
        }

    }

}

class Process implements Runnable {
    private int val;

    Process(int a) {
        val = a;
    }

    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }

        System.out.println(val);
    }
}
