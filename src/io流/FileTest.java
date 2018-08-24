package io流;

import java.io.File;

public class FileTest {
    public static void main(String[] args) {
        System.out.println(File.pathSeparator);
        System.out.println(File.separator);
        System.out.println(File.pathSeparatorChar);
        System.out.println(File.separatorChar);
        //路径表示形式
        String path = "C:\\Users\\73493\\Documents\\java-本科2年.doc";
        String path1 = "C:"+File.separator+"Users"+File.separator+"73493"+File.separator+"Documents"+File.separator+"java-本科2年.doc";
        System.out.println(path1);
        System.out.println(path);
        String path3 = "C:/Users/73493/Documents/java-本科2年.doc";
        File file = new File(path3);
        System.out.println(file.getParentFile());
        File file1 = new File("C:/Users/73493/Documents");
        File file2 = new File(file1,"java-本科2年.doc");
        System.out.println(file2.getAbsoluteFile());
        System.out.println(file2.getAbsolutePath());
    }
}
