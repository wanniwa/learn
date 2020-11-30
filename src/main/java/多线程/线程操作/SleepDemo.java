package 多线程.线程操作;

public class SleepDemo extends Thread {
    public static void main(String[] args) throws InterruptedException {
        SleepDemo sleepDemo = new SleepDemo();
        sleepDemo.start();
        for (int i = 0; i < 10; i++) {
            if (i == 5) {
                System.out.println("sleep 5s");
                sleep(10000);
            }
            System.out.println("main"+i);
        }
    }
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("sleep"+i);
        }
    }
}
