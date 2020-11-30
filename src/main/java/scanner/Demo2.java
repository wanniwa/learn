package scanner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author wanniwa
 * @date 2018/6/22 15:33
 */
public class Demo2 {
    public static void main(String[] args) throws IOException {
        System.out.println("请输入一个字符串");
        BufferedReader buf= new BufferedReader(new InputStreamReader(System.in));
        String str = buf.readLine();
        System.out.println(str);
    }
}
