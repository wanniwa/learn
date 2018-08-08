package 常用类.文件;

import java.io.File;

public class FileTreeTest {
    public static void main(String[] args) {
        File f = new File("d:/");
        printFile(f,0 );
    }
    static void printFile(File file,int level){
        for (int i = 0; i < level; i++) {
            System.out.print("-");
        }
        System.out.println(file.getName());
        if (file.isDirectory()){
            File[] files = file.listFiles();
            if (files!=null){
                for (File file1 : files) {
                    printFile(file1,level+1);
                }
            }
        }
    }

}
