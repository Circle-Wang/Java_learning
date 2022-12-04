package Demo1;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

public class TestInet {
    public static void main(String[] args) {
        try {
            // 获取InetAddress对象的方式
            InetAddress inetAddress1 = InetAddress.getByName("127.0.0.1");  // 访问本机IP
            InetAddress inetAddress2 = InetAddress.getByName("www.baidu.com"); // 访问百度IP
            InetAddress inetAddress3 = InetAddress.getLocalHost(); // 访问本机地址

            System.out.println(inetAddress1);
            System.out.println(inetAddress2);
            System.out.println(inetAddress3);
            System.out.println("===========");

            // 获取InetSocketAddress对象的方式
            InetSocketAddress socketAddress = new InetSocketAddress("127.0.0.1", 8080);
            InetAddress inetAddress4 = socketAddress.getAddress(); // 可以得到InetAddress对象
            System.out.println(socketAddress);
            System.out.println(inetAddress4);
            System.out.println(socketAddress.getPort()); // 获取端口号

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
