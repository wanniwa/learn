package 多线程.线程操作;

public class YieldDemo01 extends Thread {
    public static void main(String[] args) throws InterruptedException {
        YieldDemo01 demo01 = new YieldDemo01();
        demo01.start();
        for (int i = 0; i < 100; i++) {

            if (i % 30 == 0) {
                //暂停本线程 但不一定会成功
                Thread.yield();
            }
            System.out.println("main" + i);
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {

            System.out.println("Join" + i);
        }
    }
}
