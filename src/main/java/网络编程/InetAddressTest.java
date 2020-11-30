package 网络编程;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {
    public static void main(String[] args) throws UnknownHostException {
        //使用getLocalHost方法创建InetAddress对象
        InetAddress localHost = InetAddress.getLocalHost();

        System.out.println("hostAddress:"+ localHost.getHostAddress());
        System.out.println("hostName:"+ localHost.getHostName());


        InetAddress address = InetAddress.getByName("www.baidu.com");
        System.out.println("hostAddress:"+ address.getHostAddress());
        System.out.println("hostName:"+ address.getHostName());

        InetAddress address1 = InetAddress.getByName("180.97.33.107");
        System.out.println("hostAddress:"+ address1.getHostAddress());
        System.out.println("hostName:"+ address1.getHostName());

    }
}
