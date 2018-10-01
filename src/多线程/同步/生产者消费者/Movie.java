package 多线程.同步.生产者消费者;

/**
 * 一个场景，共同的资源
 * 生产者消费者模式 信号灯法
 */
public class Movie {
    private String pic;
    /**
     * 信号灯
     * flag true 生产者生产，消费者等待，生产完成后通知消费者
     * flag false 消费者消费，生产者等待，消费完成后通知生产者
     */
    private boolean flag = true;

    /**
     * 播放
     */
    public synchronized void play(String pic) {
        if (!flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //开始生产
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //生产完毕
        this.pic = pic;
        System.out.println("生产了" + pic);
        //通知消费
        this.notify();
        //生产者停下
        this.flag = false;
    }

    public synchronized void watch() {
        if (flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //开始消费
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("消费了" + pic);
        //消费完毕
        //通知生产
        this.notifyAll();
        //消费停止
        this.flag = true;

    }
}
