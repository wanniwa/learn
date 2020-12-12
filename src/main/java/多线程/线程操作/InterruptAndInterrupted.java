package 多线程.线程操作;

import java.util.concurrent.TimeUnit;

public class InterruptAndInterrupted {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            while (true) {
                boolean interrupted = Thread.currentThread().isInterrupted();
                System.out.println(interrupted);
                if (Thread.interrupted()) {
                    System.out.println("Thread is interrupted!");
                    break;
                }
            }
        });
        t.start();
        TimeUnit.MILLISECONDS.sleep(2001);
        t.interrupt();
    }
}
