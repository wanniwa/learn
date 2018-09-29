package 多线程.同步;

/**
 * 单例设计模式
 */
public class SysDemo02 {

    public static void main(String[] args) {

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
    public static Jvm getInstance(){
        if (null==instance){
            instance = new Jvm();
        }
        return instance;
    }

}
