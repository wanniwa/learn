package 手写服务器.demo1;

import 网络编程.TCP.chat.demo03.CloseUtil;

import java.io.IOException;
import java.net.Socket;

public class DisPatcher implements Runnable {
    private Request request;
    private Response response;
    private Socket client;
    private int code = 200;
    public DisPatcher(Socket client) {
        this.client = client;
        try {
            request = new Request(client.getInputStream());
            response = new Response(client.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
            code=500;
        }

    }

    @Override
    public void run() {
        Servlet servlet = new Servlet();

        servlet.service(request ,response);
        try {
            response.pushToClient(code);
        } catch (IOException e) {

        }
        try {
            response.pushToClient(500);
        } catch (IOException e) {
            e.printStackTrace();
        }
        CloseUtil.closeAll(client);
    }
}
