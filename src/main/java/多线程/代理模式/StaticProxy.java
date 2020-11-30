package 多线程.代理模式;

/**
 * 静态代理设计模式
 * 1 真实角色
 * 2 代理角色
 * 要求
 * 1 两者实现相同的接口
 * 2 代理角色要持有真实角色的引用
 */
public class StaticProxy {

    public static void main(String[] args) {
        You you = new You();
        WeddingComany weddingComany = new WeddingComany(you);
        weddingComany.marry();
    }
}

interface Marry {
    public abstract void marry();
}

//真实角色
class You implements Marry {

    @Override
    public void marry() {
        System.out.println("我和车银优结婚了");
    }
}

class WeddingComany implements Marry {
    private Marry you;

    @Override
    public void marry() {
        before();
        you.marry();
        after();
    }

    public WeddingComany() {
    }

    public WeddingComany(Marry you) {

        this.you = you;
    }

    private void before() {
        System.out.println("布置婚房");
    }

    private void after() {
        System.out.println("闹洞房");
    }


}
