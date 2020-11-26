package 多线程.线程操作;

public class JoinDemo extends Thread {
    public static void main(String[] args) throws InterruptedException {
        JoinDemo joinDemo = new JoinDemo();
        joinDemo.start();
        for (int i = 0; i < 10; i++) {
            if (i == 5) {
                joinDemo.join();
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
