package 多线程.同步;

public class SynDemo01 implements Runnable {
    private int num = 20;
    private boolean flag = true;

    @Override
    public void run() {
        while (flag) {
            test5();
        }

    }

    public synchronized void test2() {
        if (num < 0) {
            flag = false;
            return;
        }
        try {
            Thread.sleep(500);//模拟延时
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "抢到了" + num--);
    }

    /**
     * 锁定范围不正确
     */
    public void test4() {
        synchronized (this) {
            if (num < 0) {
                flag = false;
                return;
            }
        }
        try {
            Thread.sleep(500);//模拟延时
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "抢到了" + num--);

    }
    //锁定资源不正确
    public void test5() {
        synchronized ((Integer) num) {
            if (num < 0) {
                flag = false;
                return;
            }

            try {
                Thread.sleep(500);//模拟延时
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "抢到了" + num--);
        }
    }

    public void test3() {
        synchronized (this) {
            if (num < 0) {
                flag = false;
                return;
            }
            try {
                Thread.sleep(500);//模拟延时
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "抢到了" + num--);
        }
    }

    public void test1() {
        if (num < 0) {
            flag = false;
            return;
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "抢到了" + num--);
    }

    public static void main(String[] args) {
        SynDemo01 web12306 = new SynDemo01();
        Thread thread = new Thread(web12306, "路人1");
        Thread thread1 = new Thread(web12306, "路人2");
        Thread thread2 = new Thread(web12306, "路人3");
        thread.start();
        thread1.start();
        thread2.start();
    }
}
