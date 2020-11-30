package scanner;

import java.util.Scanner;

/**
 * @author wanniwa
 * @date 2018/6/22 16:22
 */
public class Demo5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个整数");
        int x = sc.nextInt();
        System.out.println(x);

        System.out.println("请输入一个字符串");
        String str= sc.nextLine();
        System.out.println(str);
    }
}
