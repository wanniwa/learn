package 多线程.方法一Thread;

public class Tortoise extends Thread {
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            System.out.println("乌龟跑了"+i+"步");
        }
    }
}
