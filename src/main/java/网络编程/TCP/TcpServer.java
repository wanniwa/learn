package 网络编程.TCP;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 1 创建服务器 指定端口
 * 2 接收客户端请求
 * 3 发送数据 + 接收数据
 */
public class TcpServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        Socket socket = serverSocket.accept();
        System.out.println("一个客户建立连接");
        //3 发送数据
        String msg = "欢迎使用";
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bw.write(msg);
        bw.newLine();
        bw.flush();

    }
}
