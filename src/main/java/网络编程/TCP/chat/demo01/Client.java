package 网络编程.TCP.chat.demo01;

import java.io.*;
import java.net.Socket;

/**
 * 创建客户端
 *
 * 输入流和输出流在用一个线程内应该独立出来
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("localhost", 9999);
        //控制台输入流
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        DataInputStream dis = new DataInputStream(client.getInputStream());
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());

        while (true) {
            String info = console.readLine();
            //输出流
            dos.writeUTF(info);
            dos.flush();

            //输入流
            String msg = dis.readUTF();
            System.out.println(msg);
        }
    }
}
