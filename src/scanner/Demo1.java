package scanner;

import java.io.IOException;

/**
 * @author wanniwa
 * @date 2018/6/22 15:08
 */
public class Demo1 {
    public static void main(String[] args) throws IOException {
        System.out.println("请输入一个字符");
        char read = (char) System.in.read();
        System.out.println("char: "+ read);
    }
}
