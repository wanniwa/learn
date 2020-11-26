package 多线程.线程操作;

public class ThreadInfoDemo {
    public static void main(String[] args) throws InterruptedException {
        MyThread threadDemo = new MyThread();
        Thread thread = new Thread(threadDemo,"test");
        System.out.println(thread.getName());
        System.out.println(Thread.currentThread().getName());
        thread.start();
        System.out.println("启动后的状态："+thread.isAlive());
        Thread.sleep(200);
        threadDemo.stop();
        Thread.sleep(200);
        System.out.println("关闭后的状态："+thread.isAlive());
    }
}
