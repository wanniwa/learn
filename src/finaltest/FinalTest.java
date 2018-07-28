package finaltest;

/**
 * @author wanniwa
 * @date 2018/7/6 10:28
 */
public class FinalTest {
    public static void main(String[] args) {
        final String a = "你";
        final String b = "好";
        String c = a + b;
        String d = "你好";
        System.out.println(c == d); //true
    }
}
