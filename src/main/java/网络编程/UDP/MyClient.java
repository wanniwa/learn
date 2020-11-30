package 网络编程.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class MyClient {
    public static void main(String[] args) throws IOException {
        //1 创建服务端+端口
        DatagramSocket client = new DatagramSocket(6666);
        //2 准备数据
        String msg = "udp编程";
        byte[] data = msg.getBytes();
        //3 打包（发送的地点和端口）
        DatagramPacket packet = new DatagramPacket(data, data.length, new InetSocketAddress("localhost", 8888));
        //4 发送
        client.send(packet);
        //5 释放
        client.close();

    }
}
