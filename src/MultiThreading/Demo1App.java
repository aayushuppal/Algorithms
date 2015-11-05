package MultiThreading;

/**
 * Created by hellsapphire on 10/24/2015.
 */
public class Demo1App {

    public static void main(String[] args) {
        Runner runner1 = new Runner();
        runner1.start();

        Runner runner2 = new Runner();
        runner2.start();
        /*
        Over here if i called runner1.run directly it will execute the run block code
        in this main thread rather than the separate thread we intended
         */
    }
}

class Runner extends Thread {

    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("hello " + i);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
