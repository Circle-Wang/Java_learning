package Demo4;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPClient2 {
    public static void main(String[] args) throws IOException {

        DatagramSocket socket = new DatagramSocket(9650);  // 监听9650端口
        
        // 封装接收数据包
        byte[] buffer = new byte[1024];   // 用于储存接收信息的数组
        DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length);

        // 接收信息(会阻塞，直到接收到结果)
        socket.receive(packet);

        System.out.println(packet.getAddress().getHostAddress()); // 查看包裹来自哪里
        System.out.println(new String(packet.getData()));         // 提取接收到的包裹信息

        // 关闭数据流
        socket.close();
        
    }
}
