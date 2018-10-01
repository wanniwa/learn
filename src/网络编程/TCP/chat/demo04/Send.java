package 网络编程.TCP.chat.demo04;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Send implements Runnable {
    private BufferedReader console;
    private DataOutputStream dos;
    private boolean isRunning = true;
    private String name;
    public Send() {
        console = new BufferedReader(new InputStreamReader(System.in));
    }

    public Send(Socket client, String name) {
        this();
        try {
            dos = new DataOutputStream(client.getOutputStream());
            this.name= name;
            send(this.name);
        } catch (IOException e) {
            isRunning = false;
            CloseUtil.closeAll(dos, console);
        }
    }

    /**
     * 1从控制台接收数据
     * 2 发送数据
     */
    public void send(String msg){

        if (msg != null) {
            try {
                dos.writeUTF(msg);
                dos.flush();
            } catch (IOException e) {
                //e.printStackTrace();
                isRunning = false;
                CloseUtil.closeAll(dos,console);
            }
        }
    }
    private String getMsgFromConsole(){
        try {
            return console.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public void run() {
        while (isRunning) {
            send(getMsgFromConsole());
        }
    }
}
