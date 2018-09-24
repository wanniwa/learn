package io流.其它流.处理流;

import java.io.*;

public class DataDemo02 {
    public static void main(String[] args) throws IOException {
        byte[] data = write();
        System.out.println(data.length);
        read(data);

    }
    public static byte[] write() throws IOException {
        //目标数组
        byte[] dest;

        long num = 100L;
        double point = 2.5;
        String str = "你好";
        double point1 = 2.51;

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(
                new BufferedOutputStream(
                        bos
                )
        );
        dos.writeDouble(point);
        dos.writeLong(num);
        dos.writeUTF(str);
        dos.writeDouble(point1);
        dos.flush();
        dos.close();
        dest = bos.toByteArray();
        return dest;

    }

    /**
     * 从数组中读取数据+类型
     * @param src
     * @throws IOException
     */
    public static void read(byte[] src) throws IOException {
        DataInputStream dis = new DataInputStream(
                new BufferedInputStream(
                        new ByteArrayInputStream(src)
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
