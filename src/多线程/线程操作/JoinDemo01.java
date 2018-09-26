package 多线程.线程操作;

public class JoinDemo01 extends Thread {
    public static void main(String[] args) throws InterruptedException {
        JoinDemo01 joinDemo01 = new JoinDemo01();
        joinDemo01.start();
        for (int i = 0; i < 10; i++) {
            if (i == 5) {
                joinDemo01.join();
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
