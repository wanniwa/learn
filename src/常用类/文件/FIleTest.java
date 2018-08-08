package 常用类.文件;

import java.io.File;
import java.io.IOException;

public class FIleTest {
    public static void main(String[] args) throws IOException {
        File f =new File("d:/text.txt");
        File f1 =new File( "d:/");
        File f2 = new File(f1,"text1.txt");
        File f3 = new File("d:/a/b/c");
        f3.mkdirs();
        if (f.exists()){
            System.out.println("text.txt文件已存在");
        }else {
            System.out.println("text.txt文件不存在开始创建");
            boolean newFile = f.createNewFile();
            if (newFile){
                System.out.println("text.txt文件创建成功");
            }else {
                System.out.println("text.txt文件创建失败");
            }
        }
        if (f.isFile()){
            System.out.println("text.txt该文件是一个文件");
        }
    }
}
