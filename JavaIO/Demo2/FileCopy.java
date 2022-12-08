package Demo2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {
    public static void main(String[] args) {
        
        FileInputStream fileIS = null;
        FileOutputStream fileOS = null;

        try {
            fileOS = new FileOutputStream("Demo2/拷贝完成后的图片.jpg");  // 拷贝到哪里
            fileIS = new FileInputStream("Demo2/待拷贝图片.jpg");       // 源文件

            byte[] buffer = new byte[1024];   // 一次读取1024个字节
            int readLen = 0;
            while ((readLen = fileIS.read(buffer)) != -1) {
                // 此时字节数据已经在buffer中了，接下来是写出文件
                fileOS.write(buffer, 0, readLen);
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileOS != null){
                    fileOS.close();
                }
                if (fileIS != null) {
                    fileIS.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
    }
    
}
