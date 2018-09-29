package 多线程.同步.生产者消费者;

/**
 * 生产者
 */
public class Player implements Runnable{

    private Movie m  ;

    public Player(Movie m) {
        this.m = m;
    }

    @Override
    public void run() {

    }
}
