package 多线程.方法二Runnable;

public class Start {
    public static void main(String[] args) {
        Programmer programmer = new Programmer();
        Thread proxy = new Thread(programmer);
        proxy.start();
        for (int i = 0; i < 1000; i++) {
            System.out.println("一边聊QQ");
        }
    }
}
