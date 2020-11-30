package 手写服务器.demo1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server2 {
    private ServerSocket server;
    public static void main(String[] args) {
        Server2 server= new Server2();
        server.start();
    }

    /**
     * 启动方法
     */
    public void start() {
        try {
            server = new ServerSocket(8888);

            this.receive();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 停止
     */
    public void stop() {

    }

    /**
     * 接受客户端
     */
    private void receive() {
        try {
            Socket client = server.accept();
            String msg ;//接收客户端请求信息

            byte[] data = new byte[20480];
            int len = client.getInputStream().read(data);
            //接收客户端请求信息
            String requestInfo = new String(data, 0, len).trim();
            System.out.println(requestInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
