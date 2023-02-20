package Demo4;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;


public class UDPClient1 {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket();  // 随机绑定一个端口上，用于发送数据

        // 准备数据
        String mag = "你好服务器!";

        // 向谁发送
        InetSocketAddress anotherIP = new InetSocketAddress("127.0.0.1", 9650);
        
        // 封装好数据和目的地
        DatagramPacket packet = new DatagramPacket(mag.getBytes(), 0, mag.getBytes().length, anotherIP);

        // 发送信息
        socket.send(packet);

        // 关闭数据流
        socket.close();
        
    }
}
