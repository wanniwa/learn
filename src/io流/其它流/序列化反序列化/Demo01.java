package io流.其它流.序列化反序列化;

import java.io.*;

/**
 * 反序列化输入流 ObjectInputStream readObject
 * 序列化输出流 ObjectOutputStream writeObject
 */
public class Demo01 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        read("seri.txt");
    }

    public static void read(String destPath) throws IOException, ClassNotFoundException {
        File src = new File(destPath);
        ObjectInputStream dis = new ObjectInputStream(
                new BufferedInputStream(
                        new FileInputStream(destPath)
                )
        );

        Employee employee = (Employee) dis.readObject();
        dis.close();
        //因为age被transient 所以age会变成默认为0
        System.out.println(employee);
    }
    public static void seri(String destPath) throws IOException {
        Employee employee = new Employee("王宁",100,10);
        File dest = new File(destPath);
        ObjectOutputStream dos = new ObjectOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(dest)
                )
        );
        dos.writeObject(employee);
        dos.flush();
        dos.close();
    }
}
