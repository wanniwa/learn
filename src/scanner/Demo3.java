package scanner;

import java.util.Scanner;

/**
 * @author wanniwa
 * @date 2018/6/22 15:59
 */
public class Demo3 {
    public static void main(String[] args) {
        while (true) {
            try {
                System.out.println("请输入一个字符串");
                Scanner sc = new Scanner(System.in);
                String str = sc.nextLine();
                System.out.println(str);

                System.out.println("请输入一个int数字");
                int x = sc.nextInt();
                System.out.println(x);

                System.out.println("请输入一个double数字");
                double y = sc.nextDouble();
                System.out.println(y);
                break;
            } catch (Exception e) {
                System.out.println("输入错误，请重新输入");
            }
        }
    }
}
