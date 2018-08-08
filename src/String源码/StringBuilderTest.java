package String源码;

/**
 * @author wanniwa
 * @date 2018/7/30 14:28
 */
public class StringBuilderTest {
    public static void main(String[] args) {
        //StringBuffer线程安全 效率低
        //StringBuilder
        StringBuilder sb = new StringBuilder();//默认长度16
        StringBuilder sb1 = new StringBuilder(32);
        StringBuilder sb2 = new StringBuilder("abcd");//默认长度16+4
        sb2.append("efg");
        sb2.append(true);
        System.out.println(sb2);
    }
}
