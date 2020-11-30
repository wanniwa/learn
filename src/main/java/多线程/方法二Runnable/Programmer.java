package 多线程.方法二Runnable;

/**
 * 推荐runnable创建线程
 * 1）、避免单继承的局限性
 * 2）、便于共享资源
 *
 * 使用Runnable创建线程
 * 1 类实现Rannable接口 + 重写 run（）方法
 * 2 启动多线程 使用静态代理
 *   1）、创建真实角色
 *   2）、创建代理角色+真实角色引用
 *   3）、调用.start()启动线程
 */
public class Programmer implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("一遍写代码一遍看视频");
        }
    }
}
