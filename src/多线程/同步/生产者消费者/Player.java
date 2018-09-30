package 多线程.同步.生产者消费者;

/**
 * 生产者
 */
public class Player implements Runnable{

    private Movie m;

    public Player() {
    }

    public Player(Movie m) {
        this.m = m;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if (0==i%2){
                m.play("左青龙");
            }else {
                m.play("右白虎");
            }
        }
    }
}
