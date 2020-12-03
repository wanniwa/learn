package 多线程.线程操作;

import 多线程.SleepHelper;

import java.util.concurrent.TimeUnit;

public class InterruptAndInterrupted {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            while (true) {
                System.out.println(Thread.currentThread().isInterrupted());
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
