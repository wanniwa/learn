package 多线程.线程操作;

public class ThreadInfoDemo {
    public static void main(String[] args) throws InterruptedException {
        MyThread threadDemo = new MyThread();
        Thread proxy = new Thread(threadDemo,"test");
        System.out.println(proxy.getName());
        System.out.println(Thread.currentThread().getName());
        proxy.start();
        System.out.println("启动后的状态："+proxy.isAlive());
        Thread.sleep(200);
        threadDemo.stop();
        Thread.sleep(200);
        System.out.println("关闭后的状态："+proxy.isAlive());

    }
}
