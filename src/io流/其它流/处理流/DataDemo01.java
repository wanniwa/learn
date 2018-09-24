package io流.其它流.处理流;

import java.io.*;

/**
 * 数据类型(基本+String) 处理流
 * 1 输入流 DataInputStream
 * 2 输出流 DataOutputStream
 */
public class DataDemo01 {
    public static void main(String[] args) throws IOException {
        read("data.txt");
    }
    public static void write(String destPath) throws IOException {
        long num = 100L;
        double point = 2.5;

        String str = "你好";
        double point1 = 2.51;
        File dest = new File(destPath);
        DataOutputStream dos = new DataOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(dest)
                )
        );
        dos.writeDouble(point);
        dos.writeLong(num);
        dos.writeUTF(str);
        dos.writeDouble(point1);
        dos.flush();
        dos.close();
    }

    public static void read(String destPath) throws IOException {
        File src = new File(destPath);
        DataInputStream dis = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream(src)
                )
        );

        double num1 = dis.readDouble();
        long num2 = dis.readLong();
        String str = dis.readUTF();
        double num3 = dis.readDouble();
        System.out.println(num1+""+num2+str+num3);
        dis.close();
    }
}
