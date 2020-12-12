package 多线程.三大特性;

import java.util.ArrayList;
import java.util.List;

public class Test {


    static List list = new ArrayList<>();

    public static void main(String[] args) {
        //定义添加数据的线程对象
        ThreadAdd threadAdd = new ThreadAdd();
        //定义取数据的线程对象
        ThreadSubtract threadSubtract = new ThreadSubtract();
        threadSubtract.setName("subtract 1 ");
        //        //测试一: 先开启添加数据的线程,再开启一个取数据的线程,大多数情况下会正常
        //        threadAdd.start();
        //        threadSubtract.start();
        //        //测试二: 先开启取数据的线程,再开启添加数据的线程, 取数据的线程会先等待, 等到添加数据之后 ,再取数据
        //        threadSubtract.start();
        //        threadAdd.start();
        //测试三: 开启两个 取数据的线程,再开启添加数据的线程
        ThreadSubtract threadSubtract2 = new ThreadSubtract();
        threadSubtract2.setName("subtract 2 ");
        threadSubtract.start();
        threadSubtract2.start();
        threadAdd.start();


    }


    public static void subtract() {
        synchronized (list) {
            if (list.size() == 0) {
                try {
                    System.out.println(Thread.currentThread().getName() + " begin wait....");
                    list.wait();
                    //等待
                    System.out.println(Thread.currentThread().getName() + " end wait..");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Object data = list.remove(0);
            //从集合中取出一个数据
            System.out.println(Thread.currentThread().getName() + "从集合中取了" + data + "后,集合中数据的数量:" + list.size());

        }
    }

    public static void add() {
        synchronized (list) {
            list.add("data");
            System.out.println(Thread.currentThread().getName() + "存储了一个数据");
            list.notify();
        }
    }

    //4)定义线程类调用 add()取数据的方法
    static class ThreadAdd extends Thread {
        @Override
        public void run() {
            add();
        }
    }

    //定义线程类调用 subtract()方法
    static class ThreadSubtract extends Thread {
        @Override
        public void run() {
            subtract();
        }
    }
}
