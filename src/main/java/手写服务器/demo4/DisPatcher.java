package 手写服务器.demo4;

import 网络编程.TCP.chat.demo03.CloseUtil;

import java.io.IOException;
import java.net.Socket;

public class DisPatcher implements Runnable {
    private Request req;
    private Response rep;
    private Socket client;
    private int code = 200;

    public DisPatcher(Socket client) {
        this.client = client;
        try {
            req = new Request(client.getInputStream());
            rep = new Response(client.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
            code = 500;
        }

    }

    @Override
    public void run() {
        try {
            Servlet serv = WebApp.getServlet(req.getUrl());
            if(null==serv){
                this.code=404; //找不到处理
            }else{
                serv.service(req, rep);
            }
            rep.pushToClient(code); //推送到客户端
        }catch (Exception e) {
            e.printStackTrace();
            this.code=500;
        }
        try {
            rep.pushToClient(500);
        } catch (IOException e) {
            e.printStackTrace();
        }
        req.close();
        rep.close();
        CloseUtil.closeAll(client);
    }
}
