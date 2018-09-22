package io流;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamTest {

    public static void main(String[] args) {
        try (

                FileInputStream fis = new FileInputStream("E:\\gitWork\\learn\\src\\io流\\FileOutputStreamTest.java");
                //第二个参数代表是否是追加
                FileOutputStream fos = new FileOutputStream("file.txt",true)
        ) {
            byte[] bbuf = new byte[32];
            int hasRead = 0;
            while ((hasRead = fis.read(bbuf)) > 0) {
                fos.write(bbuf, 0, hasRead);
            }
        } catch (IOException e) {

            e.printStackTrace();

        }

    }
}
