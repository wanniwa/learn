package io流.其它流.字节流;

import java.io.*;

/**
 * 1文件---程序----文件
 * 文件输入流
 * 字节数组输出流
 * <p>
 * 2 字节数组--程序---文件
 * 字节数组输入流
 * 文件输出流
 */
public class ByteArrayDemo02 {
    public static void main(String[] args) throws IOException {
        byte[] data = getBytesFromFile("E:\\IdeaProjects\\learn\\file.txt");
        System.out.println( new String(data));
        toFileFromByteArray(data,"file1.txt");
    }

    public static void toFileFromByteArray(byte[] src ,String destPath) throws IOException {
        File dest = new File(destPath);
        InputStream is = new BufferedInputStream(new ByteArrayInputStream(src));
        OutputStream os = new BufferedOutputStream(new FileOutputStream(dest));
        byte[] flush = new byte[1024];
        int len;
        while (-1!=(len=is.read(flush))) {
            //写出到字节数组流中
            os.write(flush,0,len);
        }
        os.flush();
        os.close();
        is.close();
    }

    public static byte[] getBytesFromFile(String srcPath) throws IOException {
        //创建文件源
        File src = new File(srcPath);
        //创建字节数组目的地
        byte[] dest = null;
        InputStream is = new BufferedInputStream(new FileInputStream(src));
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        byte[] flush = new byte[1024];
        int len;
        while (-1!=(len=is.read(flush))) {
            //写出到字节数组流中
            bos.write(flush,0,len);
        }
        bos.flush();
        dest = bos.toByteArray();
        bos.close();
        is.close();
        return dest;
    }

}
