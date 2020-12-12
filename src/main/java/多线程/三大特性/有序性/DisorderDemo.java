package 多线程.三大特性.有序性;

import java.util.concurrent.CountDownLatch;

public class DisorderDemo {
    private static int x = 0, y = 0;
    private static int a = 0, b = 0;
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; true; i++) {
            x = 0;
            y = 0;
            a = 0;
            b = 0;
            CountDownLatch latch = new CountDownLatch(2);
            Thread one = new Thread(new Runnable() {
                @Override
                public void run() {
                    a = 1;
                    x = b;
                    latch.countDown();

                }
            });
            Thread others = new Thread(new Runnable() {
                @Override
                public void run() {
                    b = 1;
                    y = a;
                }
            });
            one.start();
            others.start();
            latch.await();
            String result = "第" + i + "次（" + x + "," + y + ")";
            if (x == 0 & y == 0) {
                System.err.println(result);
                break;
            }
        }
    }
}
