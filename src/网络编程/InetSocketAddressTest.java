package 网络编程;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

public class InetSocketAddressTest {
    public static void main(String[] args) throws UnknownHostException {
        //InetSocketAddress address = new InetSocketAddress("localhost", 9999);
        //InetSocketAddress address = new InetSocketAddress("127.0.0.1", 9999);
        InetSocketAddress address = new InetSocketAddress(InetAddress.getByName("127.0.0.1"), 9999);
        System.out.println(address.getHostName());
        System.out.println(address.getPort());

        InetAddress add = address.getAddress();
        System.out.println(add.getHostName());//返回地址
        System.out.println(add.getHostAddress());//输出计算机名

    }
}
