package Demo2;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;


public class TcpClient {
    public static void main(String[] args) throws InterruptedException {
        Socket socket = null;
        OutputStream os = null;
        try {
            // 服务器的IP
            InetAddress serverIP = InetAddress.getByName("127.0.0.1");

            // 创建一个连接
            socket = new Socket(serverIP, 52503);
            // 发送信息的IO流
            os = socket.getOutputStream();

            // 发送信息
            os.write("客户端发来了一条信息".getBytes());
            

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            try {
                if(os != null) os.close(); // 执行到此处时才会向服务器端读取终止符号，让服务器停止读取
                if(socket != null) socket.close(); 
            } catch (IOException e) {
                e.printStackTrace();
            }
            
        }

    }
    
}
