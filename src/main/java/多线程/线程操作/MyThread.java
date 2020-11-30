package 多线程.线程操作;

/**
 *
 * Thread.currentThread() 当前线程
 * setName(); 设置名称
 * getName(); 获得名称
 * isAlive(); 是否活着
 *
 */
public class MyThread implements Runnable {
    private boolean flag = true;
    private int num = 0;
    @Override
    public void run() {
        while (flag) {
            System.out.println(Thread.currentThread().getName()+"----"+num++);
        }
    }
    public void stop(){
        this.flag = false;
    }


}
