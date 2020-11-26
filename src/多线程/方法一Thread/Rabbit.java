package 多线程.方法一Thread;

public class Rabbit extends Thread{
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            System.out.println("兔子跑了"+i+"步");
        }
    }
}
