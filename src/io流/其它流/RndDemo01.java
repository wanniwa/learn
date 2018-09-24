package io流.其它流;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 文件分割思路
 * 1 分割的块数
 */
public class RndDemo01 {
    public static void main(String[] args) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(new File("print.txt"),"r");
        randomAccessFile.seek(1);
        byte[] flush = new byte[1024];
        int len;
        while (-1 != (len = randomAccessFile.read(flush))) {
            if (len>200){
                System.out.println(new String(flush, 0, 200));
                break;
            }else {
                System.out.println(new String(flush, 0, len));
            }
        }
        randomAccessFile.close();
    }
}
