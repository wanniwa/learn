package io流.其它流.打印流;

import java.io.*;

public class PrintStreamDemo01 {
    public static void main(String[] args) throws FileNotFoundException {
        PrintStream ps = System.out;
        ps.println("niaho");

        //输出到文件
        ps = new PrintStream(new BufferedOutputStream(new FileOutputStream(new File("print.txt"))));
        ps.println("io流 is so easy");
        ps.close();
    }
}
