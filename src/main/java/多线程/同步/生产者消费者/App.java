package 多线程.同步.生产者消费者;

public class App {
    public static void main(String[] args) {
        //共同资源
        Movie m = new Movie();
        Player p = new Player(m);
        Watcher w = new Watcher(m);
        new Thread(p).start();
        new Thread(w).start();

    }
}
