package 网络编程.TCP.chat.demo03;

import java.io.IOException;
import java.net.Socket;

/**
 * 创建客户端
 *
 * 输入流和输出流在用一个线程内应该独立出来
 */
public class Client {
    public static void main(String[] args) throws IOException {
       Socket client = new Socket("localhost", 9999);
       new Thread(new Send(client)).start();
       new Thread(new Receive(client)).start();
    }
}
