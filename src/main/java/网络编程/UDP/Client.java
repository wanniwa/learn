package 网络编程.UDP;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class Client {
    public static void main(String[] args) throws IOException {
        //1 创建服务端+端口
        DatagramSocket client = new DatagramSocket(6666);
        //2 准备数据
        byte[] data = convertDouble(3.046);
        //3 打包（发送的地点和端口）
        DatagramPacket packet = new DatagramPacket(data, data.length, new InetSocketAddress("localhost", 8888));
        //4 发送
        client.send(packet);
        //5 释放
        client.close();

    }

    public static byte[] convertDouble(double num) throws IOException {
        byte[] data ;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(bos);
        dos.writeDouble(num);
        dos.flush();
        data = bos.toByteArray();
        dos.close();
        return data;
    }
}
