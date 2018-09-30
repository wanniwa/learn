package 多线程.同步.单例模式;

/**
 * 单例设计模式
 */
public class SysDemo02 {

    public static void main(String[] args) {
        JvmThread thread1 = new JvmThread(100);
        JvmThread thread2 = new JvmThread(500);
        thread1.start();
        thread2.start();

    }
}

class JvmThread extends Thread {
    private long time;

    public JvmThread() {
    }

    public JvmThread(long time) {
        this.time = time;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ">>>>>创建" + Jvm.getInstance(time));
    }
}

/**
 * 单列设计模式
 * 确保一个类只有一个的对象
 * 懒汉式
 * 1 构造器私有化，避免直接外部创建对象
 * 2 声明一个私有的静态变量
 * 3 创建一个对外的静态方法访问改变量，如果变量没有对象创建该对象
 */
class Jvm {

    private static Jvm instance = null;

    // 避免外部重新创建对象
    private Jvm() {

    }

    public static Jvm getInstance(long time) {
        //提高效率 提高已经存在对象的访问效率
        if (null == instance) {
            //a , b 效率不高
            synchronized (Jvm.class) {
                if (null == instance) {
                    try {
                        Thread.sleep(time);//延时放大错误
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    instance = new Jvm();
                }
            }
        }
        return instance;
    }

    public static Jvm getInstance3(long time) {
        //a , b 效率不高
        synchronized (Jvm.class) {
            if (null == instance) {
                try {
                    Thread.sleep(time);//延时放大错误
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                instance = new Jvm();
            }
            return instance;
        }
    }

    public static synchronized Jvm getInstance2(long time) {
        if (null == instance) {
            try {
                Thread.sleep(time);//延时放大错误
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            instance = new Jvm();
        }
        return instance;
    }
}
