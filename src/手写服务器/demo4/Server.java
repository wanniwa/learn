package 手写服务器.demo4;

import 网络编程.TCP.chat.demo03.CloseUtil;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 请求并响应
 */
public class Server {
    private ServerSocket server;
    public static final String CRLF = "\r\n";
    public static final String BLANK = " ";
    private boolean isShutDown = false;
    public static void main(String[] args) {
        Server server = new Server();
        server.start();
    }

    /**
     * 启动方法
     */
    public void start() {
        start(8888);
    }
    public void start(int port) {
        try {
            server = new ServerSocket(port);

            this.receive();
        } catch (IOException e) {
            e.printStackTrace();
            stop();
        }
    }
    /**
     * 停止
     */
    public void stop() {
        isShutDown = true;
        CloseUtil.closeAll(server);

    }

    /**
     * 接受客户端
     */
    private void receive() {
        try {
            while (!isShutDown) {
                Socket client = server.accept();
                new Thread(new DisPatcher(client)).start();
            }

        } catch (IOException e) {
           stop();
        }
    }
}

