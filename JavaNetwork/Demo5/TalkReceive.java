package Demo5;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class TalkReceive implements Runnable{

    DatagramSocket socket = null;
    private int fromPart;

    public TalkReceive(int fromPart) {
        // 需要告知监听哪一个端口
        this.fromPart = fromPart;

        try {
            socket = new DatagramSocket(this.fromPart);  // 监听目标窗口
        } catch (SocketException e) {
            e.printStackTrace();
        }  

    }



    @Override
    public void run() {

        while (true) {
            try {
                byte[] buffer = new byte[1024];   // 用于储存接收信息的数组
                DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length);
                socket.receive(packet);  // 接收信息(会阻塞，直到接收到结果)
                
                // 处理包裹信息
                String receiveData = new String(packet.getData());
                String receiveIP = packet.getSocketAddress().toString();

                // 打印信息
                System.out.println(receiveIP + ": "+ receiveData);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

}
