package 多线程.三大特性;

import 多线程.SleepHelper;

public class HelloVolatile {
    private static volatile boolean flag = true;

    public static void m() {
        System.out.println("start");

        while (flag) {
            //System.out.println(flag);
        }
        System.out.println("end");
    }

    public static void main(String[] args) {
        new Thread(HelloVolatile::m).start();
        SleepHelper.sleepSeconds(1);
        flag = false;
    }
}
