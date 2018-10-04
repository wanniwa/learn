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

            byte[] data = new byte[20480];
            int len = client.getInputStream().read(data);
            //接收客户端请求信息
            String requestInfo = new String(data, 0, len).trim();
            System.out.println(requestInfo);


            Response response = new Response(client);
            response.println("<html lang=\"en\"><head><meta charset=\"UTF-8\"><title>HTTP响应势力</title></head><body>nihao</body></html>");

            response.pushToClient(200);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
