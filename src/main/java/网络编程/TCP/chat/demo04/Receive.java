package 网络编程.TCP.chat.demo04;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class Receive implements Runnable{
    //输入流
    private DataInputStream dis ;
    private boolean isRunning = true;
    public Receive() {
    }

    public Receive(Socket client) {
        try {
            dis = new DataInputStream(client.getInputStream());
        } catch (IOException e) {
            //e.printStackTrace();
            isRunning = false;
            CloseUtil.closeAll(dis);
        }
    }

    /**
     * 接收数据
     * @return
     */
    public String receive(){
        String msg = null;
        try {
            msg= dis.readUTF();
        } catch (IOException e) {
            //e.printStackTrace();
            isRunning = false;
            CloseUtil.closeAll(dis);
        }
        return msg;
    }
    @Override
    public void run() {
        while (isRunning) {
            System.out.println(receive());
        }
    }
}
