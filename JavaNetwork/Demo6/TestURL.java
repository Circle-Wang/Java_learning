package Demo6;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class TestURL {

    public static void main(String[] args) throws IOException {
        // 找到下载地址(图片地址)
        URL url = new URL("https://t7.baidu.com/it/u=1819248061,230866778&fm=193&f=GIF");

        // 连接到这个资源
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        InputStream inputStream = httpURLConnection.getInputStream();

        FileOutputStream fos = new FileOutputStream("保存文件名.jpg");
        byte[] buffer = new byte[1024];
        int len;
        while ((len=inputStream.read(buffer)) != -1) {
            fos.write(buffer,0,len);
        }

        // 释放资源
        fos.close();
        inputStream.close();
        httpURLConnection.disconnect();

    }
    
}
