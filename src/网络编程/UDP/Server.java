package 网络编程.UDP;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server {
    public static void main(String[] args) throws IOException {
        DatagramSocket server = new DatagramSocket(8888);
        byte[] content = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(content, content.length);
        server.receive(datagramPacket);
        double data = convert(datagramPacket.getData());
        System.out.println(data);

    }

    public static double convert(byte[] data) throws IOException {
        DataInputStream dis = new DataInputStream(new ByteArrayInputStream(data));
        double v = dis.readDouble();
        dis.close();
        return v;
    }
}
