package 多线程.同步;

/**
 * 死锁 互相拿着对方的锁
 * 过多的同步方法可能造成死锁
 */
public class SynDemo03 {
    public static void main(String[] args) {
        Object o = new Object();
        Object o2 = new Object();
        Test test = new Test(o,o2);
        Test2 test2 = new Test2(o,o2);
        Thread proxy = new Thread(test);
        Thread proxy1 = new Thread(test2);
        proxy.start();
        proxy1.start();
    }
}

class Test implements Runnable{
    Object goods ;
    Object money ;

    public Test(Object goods, Object money) {
        this.goods = goods;
        this.money = money;
    }



    @Override
    public void run() {
        synchronized (goods) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (money){

            }
        }
        System.out.println("一首给钱");
    }
}
class Test2 implements Runnable{
    Object goods ;
    Object money ;

    public Test2(Object goods, Object money) {
        this.goods = goods;
        this.money = money;
    }

    @Override
    public void run() {
        synchronized (money) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (goods){

            }
        }
        System.out.println("一首给货");
    }
}
