package io流.其它流.字节流;

import java.io.*;

/**
 * 字节数组节点流
 * 数组的长度有限 数据量不大
 * 1 文件内容-程序->读到字节数组
 * 2 字节数组 -程序->文件
 */
public class ByteArrayDemo01 {
    public static void main(String[] args) throws IOException {
        read(write());
    }






    public static void read(byte[] src) throws IOException {

        InputStream is = new BufferedInputStream(
                new ByteArrayInputStream(src)
        );

        byte[] flush = new byte[9];
        int len = 0;
        while (-1!=(len=is.read(flush))){
            System.out.println(new String(flush,0,len));
        }
    }

    /**
     * 输出流 操作与文件输出流有些不同 不能使用多态
     */
    public static byte[] write() throws IOException {
        //目的地
        byte[] dest ;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        String msg = "你好啊";
        byte[] info = msg.getBytes();
        bos.write(info);
        //获取数据
        dest=bos.toByteArray();
        bos.close();
        return dest;
    }
}
