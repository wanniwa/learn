package 网络编程.TCP.chat.demo04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * 创建客户端
 *
 * 输入流和输出流在用一个线程内应该独立出来
 */
public class Client {
    public static void main(String[] args) throws IOException {
        System.out.println("请输入名称：");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();
        Socket client = new Socket("localhost", 9999);
       new Thread(new Send(client,name)).start();
       new Thread(new Receive(client)).start();
    }
}
