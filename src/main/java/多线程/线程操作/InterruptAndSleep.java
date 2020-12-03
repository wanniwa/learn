package 多线程.线程操作;

import 多线程.SleepHelper;

public class InterruptAndSleep {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                System.out.println("Thread is interrupted!");
                System.out.println(Thread.interrupted());
                System.out.println(Thread.currentThread().isInterrupted());
            }
        });
        t.start();
        SleepHelper.sleepSeconds(2);
        t.interrupt();

        //Thread is interrupted!
        //false
    }
}
