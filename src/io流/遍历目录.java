package io流;

import java.io.File;

public class 遍历目录 {
    public static void main(String[] args) {
        String path = "C:/Users/73493/Documents";
        File file = new File(path);
        printName(file);
    }

    public static void printName(File src) {
        if (null == src || !src.exists()) {
            return;
        }
        System.out.println(src.getAbsolutePath());
        if (src.isDirectory()) {
            if (src.listFiles().length>0) {
                for (File sub : src.listFiles()) {
                    printName(sub);
                }
            }
        }
    }

}
