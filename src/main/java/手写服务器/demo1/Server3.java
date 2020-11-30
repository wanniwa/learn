package 手写服务器.demo1;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * 请求并响应
 */
public class Server3 {
    private ServerSocket server;
    public static final String CRLF = "\r\n";
    public static final String BLANK = " ";

    public static void main(String[] args) {
        Server3 server = new Server3();
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
            Servlet servlet = new Servlet();
            Request req = new Request(client.getInputStream());
            Response response = new Response(client.getOutputStream());
            servlet.service(req ,response);

            response.pushToClient(200);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

