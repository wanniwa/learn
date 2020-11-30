package 初始化块;

/**
 * @author wanniwa
 * @date 2018/7/7 15:12
 */
public class Test1 {

    int a = 9;
    {
        a = 6;
    }

    public static void main(String[] args) {
        System.out.println(new Test1().a);
    }
}
