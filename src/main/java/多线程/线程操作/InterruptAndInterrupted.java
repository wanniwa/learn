package 多线程.线程操作;

import 多线程.SleepHelper;

import java.util.concurrent.TimeUnit;

public class InterruptAndInterrupted {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            while (true) {
                System.out.println(Thread.currentThread().isInterrupted());
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (Thread.interrupted()) {
                    System.out.println("Thread is interrupted!");
                    break;
                }
            }
        });
        t.start();
        TimeUnit.SECONDS.sleep(1);
        t.interrupt();
    }
}
