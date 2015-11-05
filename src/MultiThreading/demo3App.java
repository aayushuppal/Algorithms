package MultiThreading;

import java.util.Scanner;

/**
 * Created by hellsapphire on 10/24/2015.
 *
 * Thread caching problem for a variable
 */
public class demo3App {

    public static void main(String[] args) {
        LowLevProcessor proc1 = new LowLevProcessor();
        proc1.start();
        // this start from proc1 runs in another thread

        System.out.print("press return to stop");
        Scanner scanIn = new Scanner(System.in);
        scanIn.nextLine();

        proc1.shutdown();
        // this shutdown runs in another thread as well from start
    }
}

class Processor extends Thread {
    private volatile boolean running = true;
    // volatile ensures the variable is not cached by individual threads and the code
    // in each thread checks for it's updated value
    // volatile ensures current state of variable is visible to all threads on the object

    public void run() {
        while (running) {
            System.out.println("Hello");

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void shutdown() {
        running = false;
    }

}