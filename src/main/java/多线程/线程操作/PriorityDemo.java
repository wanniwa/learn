package 多线程.线程操作;

public class PriorityDemo {
    /**
     * 两个线程不同优先级，同时开始累加，等待100毫秒，优先级高的数累加值更高
     */
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread1 = new MyThread();
        Thread t1 = new Thread(myThread1, "myThread1");
        MyThread myThread2 = new MyThread();
        Thread t2 = new Thread(myThread2, "myThread2");
        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        t2.start();
        Thread.sleep(100);
        myThread1.stop();
        myThread2.stop();
    }
}
