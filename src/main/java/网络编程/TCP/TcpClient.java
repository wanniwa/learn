package 网络编程.TCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * 1 创建客户端必须指定服务器+端口 此时就在连接
 * 2 接收数据 + 发送数据
 */
public class TcpClient {
    public static void main(String[] args) throws IOException {
        //建立连接
        Socket client = new Socket("localhost", 8888);
        //接收数据
        BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
        String echo = br.readLine();
        System.out.println(echo);
    }
}
