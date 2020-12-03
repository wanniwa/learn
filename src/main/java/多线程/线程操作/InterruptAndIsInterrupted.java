package 多线程.线程操作;

import 多线程.SleepHelper;

public class InterruptAndIsInterrupted {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("Thread is interrupted!");
                    System.out.println(Thread.currentThread().isInterrupted());
                    break;
                }
            }
        });
        t.start();
        SleepHelper.sleepSeconds(1);
        t.interrupt();

        //Thread is interrupted!
        //false
    }
}
