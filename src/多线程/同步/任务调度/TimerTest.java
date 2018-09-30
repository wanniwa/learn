package 多线程.同步.任务调度;

import java.util.Timer;
import java.util.TimerTask;

public class TimerTest {
    public static void main(String[] args) {
        Timer timer= new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("so easy");
            }
        },2000,1000);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("so easy2");
            }
        },2000,1000);
    }
}
