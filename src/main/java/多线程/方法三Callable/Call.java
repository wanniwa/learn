package 多线程.方法三Callable;

import java.util.concurrent.*;

/**
 * 使用Callable创建线程
 * 1）、创建Callable实现类+重写call
 * 2）、借助调度服务ExecutorService，获得Future对象
 * ExecutorService ser= Executors.newFixedThreadPool(2);
 * Future result = ser.submit(实现类对象)
 * 3）、获取值 result.get()
 * 4）、停止服务ser.shutdownNow()
 */
public class Call {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //创建一个可重用固定线程数的线程池
        ExecutorService ser = Executors.newFixedThreadPool(2);
        ExecutorService ser2 = Executors.newCachedThreadPool();
        Race tortoise = new Race("千年王八", 1000L);
        Race rabbit = new Race("兔子", 500L);
        Future<Integer> result3 = ser2.submit(tortoise);
        Future<Integer> result = ser.submit(tortoise);
        Future<Integer> result2 = ser.submit(rabbit);

        Thread.sleep(2000);
        tortoise.setFlag(false);
        rabbit.setFlag(false);

        int num1 = result.get();
        int num2 = result2.get();
        System.out.println("乌龟跑了————>" + num1);
        System.out.println("兔子跑了————>" + num2);
        ser.shutdownNow();
    }
}

class Race implements Callable<Integer> {
    private String name;//名称
    private long time;//延时时间
    private boolean flag = true;
    private int step = 0;

    public Race() {
    }

    public Race(String name) {
        this.name = name;
    }

    public Race(String name, long time) {
        this.name = name;
        this.time = time;
    }

    @Override
    public Integer call() throws Exception {
        while (flag) {
            Thread.sleep(time);
            step++;
        }
        return step;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }
}
