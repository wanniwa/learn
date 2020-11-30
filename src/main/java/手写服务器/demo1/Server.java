package 手写服务器.demo1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket server;
    public static void main(String[] args) {
        Server server= new Server();
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
            StringBuilder sb = new StringBuilder();
            BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
            while ((msg = br.readLine()).length() > 0) {
                sb.append(msg);
                sb.append("\r\n");
            }
            //接收客户端请求信息
            System.out.println(sb.toString());
            //去除空格
            //String requestInfo = sb.toString().trim();
            //System.out.println(requestInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
