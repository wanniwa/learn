package 网络编程.TCP.chat.demo03;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * 创建服务器
 */
public class Server {
    private List<MyChannel> all = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        new Server().start();
    }

    public void start() throws IOException {
        ServerSocket server = new ServerSocket(9999);
        while (true) {
            Socket client = server.accept();
            MyChannel myChannel = new MyChannel(client);
            all.add(myChannel);
            new Thread(myChannel).start();//一条道路
        }
    }


    private class MyChannel implements Runnable{
        DataInputStream dis;
        //输出流
        DataOutputStream dos;
        private Boolean isRunning = true;
        public MyChannel(Socket client) {
            try {
                dis = new DataInputStream(client.getInputStream());
                dos = new DataOutputStream(client.getOutputStream());

            } catch (IOException e) {
                e.printStackTrace();
                CloseUtil.closeAll(dis, dos);
                isRunning = false;
            }
        }

        private String receive(){
            String msg = null;
            try {
                msg = dis.readUTF();
            } catch (IOException e) {
                CloseUtil.closeAll(dis);
                isRunning = false;
                all.remove(this);
            }
            return msg;
        }
        private void send(String msg){
            if (null==msg||msg.equals("")){
                return;
            }
            try {
                dos.writeUTF(msg);
                dos.flush();
            } catch (IOException e) {
                CloseUtil.closeAll(dis);
                isRunning = false;
                all.remove(this);
            }
        }


        private void sendOther(){
            String msg = receive();
            for (MyChannel other : all) {
                if (other==this){
                    continue;
                }
                other.send(msg);
            }
        }
        @Override
        public void run() {
            while (isRunning) {
               sendOther();
            }
        }
    }
}

