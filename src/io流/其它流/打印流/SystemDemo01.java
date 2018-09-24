package io流.其它流.打印流;

import java.io.*;
import java.util.Scanner;

public class SystemDemo01 {
    public static void main(String[] args) throws FileNotFoundException {

        //test1();
        //test2();

        System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream(new File("E:\\IdeaProjects\\learn\\print.txt"),true)),true));
        System.out.println("a");
        System.out.println("cccc");
        System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream(FileDescriptor.out)),true));
        System.out.println("bbbb");
    }

    public static void test1() {
        System.out.println("错误");
        System.err.println("错误");
    }

    public static void test2() {
        InputStream is = System.in;
        Scanner sc = new Scanner(is);
        String s = sc.nextLine();
        System.out.println(s);
    }

}
