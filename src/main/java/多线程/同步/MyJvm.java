package 多线程.同步;

/**
 * 单例创建方式
 * 懒汉式
 * 1 构造器私有化
 * 2 声明私有的静态属性
 * 3 对外提供访问属性的静态方法，
 */
public class MyJvm {
    private static MyJvm myJvm = null;

    private MyJvm() {
    }
    public static MyJvm getInstance(){
        if (null== myJvm){
            synchronized (MyJvm.class) {
                if (null == myJvm) {
                    myJvm = new MyJvm();
                }

            }
        }
        return myJvm;
    }

}

 class MyJvm2 {
    private static MyJvm2 myJvm = new MyJvm2();

    private MyJvm2() {
    }
    public static MyJvm2 getInstance(){
        return myJvm;
    }
}

/**
 * 延缓了加载时间
 */
class MyJvm3 {
    private static class JVMholder{
        private static MyJvm3 myJvm = new MyJvm3();

    }

    private MyJvm3() {
    }
    public static MyJvm3 getInstance(){
        return JVMholder.myJvm;
    }
}
