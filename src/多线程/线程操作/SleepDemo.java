package 多线程.线程操作;

public class SleepDemo extends Thread {
    public static void main(String[] args) throws InterruptedException {
        SleepDemo joinDemo01 = new SleepDemo();
        joinDemo01.start();
        for (int i = 0; i < 10; i++) {
            if (i == 5) {
                sleep(10000);
            }
            System.out.println("main"+i);
        }
    }
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Join"+i);
        }
    }
}
