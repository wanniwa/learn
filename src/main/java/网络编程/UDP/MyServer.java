package 网络编程.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class MyServer {
    public static void main(String[] args) throws IOException {
        DatagramSocket server = new DatagramSocket(8888);
        byte[] content = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(content, content.length);
        server.receive(datagramPacket);
        byte[] data = datagramPacket.getData();
        int len = datagramPacket.getLength();
        System.out.println(new String(data, 0, len));

    }
}
