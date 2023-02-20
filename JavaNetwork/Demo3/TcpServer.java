package Demo3;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {

    public static void main(String[] args) throws IOException {
        
        // 开放连接端口
        ServerSocket serverSocket = new ServerSocket(9950);
        Socket socket = serverSocket.accept();  // 接收请求队列中的连接请求   
        InputStream is = socket.getInputStream();

        // 用于接收图片的保存
        FileOutputStream fos= new FileOutputStream(new File("接收到的图片.jpg"));
        byte[] buffer = new byte[1024];
        int len;
        while ((len = is.read(buffer)) != -1) {
            fos.write(buffer, 0, len);
        }  

        // 接收完毕之后，给服务器端发送一条消息
        OutputStream os = socket.getOutputStream();
        os.write("接收完毕了".getBytes());


        // 关闭资源
        fos.close();
        is.close();
        socket.close();
        serverSocket.close();

    }
    
}
