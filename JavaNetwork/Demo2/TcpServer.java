package Demo2;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {

    public static void main(String[] args) {

        // 由于需要在finally中关闭资源因此需要吧try作用域的变量提前定义
        ServerSocket serverSocket = null;
        Socket accept = null;
        InputStream iStream = null;
        ByteArrayOutputStream baos = null;

        try {
            // 创建了一可以被访问的IP:端口地址
            serverSocket = new ServerSocket(52503);

            // 使用while循环将会保证程序一直监听
            while (true) {
                // 等待服务端访问连接(此时服务会在此处陷入进程等待，直到接收到信息)
                accept = serverSocket.accept();  // 接收客户端发送的信息
                // 读取服务端发送的信息
                iStream = accept.getInputStream();

                // 以下是读取信息流的方法
                baos = new ByteArrayOutputStream();  // 管道类
                byte[] buffer = new byte[1024];
                int len;
                while ((len=iStream.read(buffer)) != -1) {
                    baos.write(buffer, 0, len);
                }
                System.out.println(baos.toString()); // 这个操作是保证不是乱码
            }
            

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            try {
                if (baos != null){
                    baos.close();
                }
                if (iStream != null){
                    iStream.close();
                }
                if (accept != null){
                    accept.close();
                }
                if (serverSocket != null){
                    serverSocket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
}
