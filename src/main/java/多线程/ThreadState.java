package 多线程;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程状态
 */
public class ThreadState {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("------------------------t1开始------------------------------");
        Thread t1 = new Thread(() -> {
            System.out.println("2:" + Thread.currentThread().getState());
            System.out.println("t1 go on!");
        });
        System.out.println("1:"+t1.getState());
        t1.start();
        t1.join();
        System.out.println("3:"+t1.getState());
        System.out.println("------------------------t1结束------------------------------");

        System.out.println("------------------------t2开始------------------------------");
        Thread t2 = new Thread(() -> {
            LockSupport.park();
            System.out.println("t2 go on!");
            SleepHelper.sleepSeconds(5);
        });
        t2.start();
        SleepHelper.sleepSeconds(1);
        System.out.println("4:"+t2.getState());
        LockSupport.unpark(t2);
        SleepHelper.sleepSeconds(1);
        System.out.println("5:"+t2.getState());
        System.out.println("------------------------t2结束------------------------------");
        System.out.println("------------------------t3开始------------------------------");
        final Object o = new Object();
        Thread t3 = new Thread(() -> {
            synchronized (o) {
                System.out.println("t3得到了锁o");
            }
        });
        new Thread(() -> {
            synchronized (o) {
                System.out.println("其他得到了锁o");
                SleepHelper.sleepSeconds(5);
                System.out.println("其他释放了锁o");
            }
        }).start();
        SleepHelper.sleepSeconds(1);
        t3.start();
        SleepHelper.sleepSeconds(1);
        System.out.println("6:"+t3.getState());
        t3.join();
        System.out.println("------------------------t3结束------------------------------");
        System.out.println("------------------------t4开始------------------------------");
        Lock lock = new ReentrantLock();
        Thread t4 = new Thread(() -> {
           lock.lock();
           System.out.println("t4得到了锁");
        });
        new Thread(() -> {
            lock.lock();
            SleepHelper.sleepSeconds(5);
            lock.unlock();
        }).start();
        SleepHelper.sleepSeconds(1);
        t4.start();
        SleepHelper.sleepSeconds(1);
        System.out.println("7:"+t4.getState());
        t4.join();
        System.out.println("------------------------t4结束------------------------------");
        System.out.println("------------------------t5开始------------------------------");
        Thread t5 = new Thread(LockSupport::park);
        t5.start();
        SleepHelper.sleepSeconds(1);
        System.out.println("8:"+t5.getState());
        LockSupport.unpark(t5);
        System.out.println("------------------------t5结束------------------------------");

    }
}
