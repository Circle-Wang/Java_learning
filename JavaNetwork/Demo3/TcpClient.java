package Demo3;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;



public class TcpClient {
    public static void main(String[] args) throws IOException {
        // 连接服务器端
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 9950);
        OutputStream os = socket.getOutputStream();

        // 读取本地图片
        FileInputStream fis = new FileInputStream(new File("Demo3/待发送图片.jpg"));
        // 将本地文件发送
        byte[] buffer = new byte[1024];
        int len;
        while ((len = fis.read(buffer)) != -1) {
            os.write(buffer,0,len);
        }

        // 数据传输完成之后需要关闭输出流, 否则服务器端会在等待read。
        socket.shutdownOutput();


        // 接下来我们等待接收服务器端传递给客户端的消息
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        InputStream is = socket.getInputStream();
        byte[] buffer2 = new byte[1024];
        int len2;
        while ((len2 = is.read(buffer2)) != -1) {
            baos.write(buffer2,0, len2);
        }
        System.out.println(baos.toString());

        // 关闭资源
        baos.close();
        is.close();
        os.close();
        fis.close();
        socket.close();


    }
    
}
