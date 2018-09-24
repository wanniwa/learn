package 多线程.方法二Runnable;

/**
 * 三个人同时抢票
 */
public class Web12306 implements Runnable {
    private int num = 1000;

    @Override
    public void run() {
        while (num > 0) {
            System.out.println(Thread.currentThread().getName() + "抢到了" + num--);
        }

    }

    public static void main(String[] args) {
        Web12306 web12306 = new Web12306();
        Thread thread = new Thread(web12306, "路人1");
        Thread thread1 = new Thread(web12306, "路人2");
        Thread thread2 = new Thread(web12306, "路人3");
        thread.start();
        thread1.start();
        thread2.start();
    }
}
