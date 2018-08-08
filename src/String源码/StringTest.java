package String源码;

/**
 * @author wanniwa
 * @date 2018/7/28 15:56
 */
public class StringTest {
    public static void main(String[] args) {
        String a = "abc";
        String b ="def";
        String c = "abcdef";
        String d  =a+b ;
        System.out.println(c==d);

        int indexOf = c.indexOf('c');
        System.out.println(indexOf);

        String e = "ABC";
        System.out.println(e.equalsIgnoreCase(a));
        System.out.println(e.startsWith("AB"));
        System.out.println(e.toLowerCase());
    }
}
