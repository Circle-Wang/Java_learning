package Demo5;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedCopyTest {
    public static void main(String[] args) {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {
            bis = new BufferedInputStream(new FileInputStream("Demo5/待拷贝图片.jpg"));  // 源文件路径
            bos = new BufferedOutputStream(new FileOutputStream("Demo5/待拷贝图片_复制.jpg"));  // 复制到的文件路径
            byte[] buffer = new byte[1024]; // 每次读入1024个数据
            int len = 0;
            while ((len = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
            }
            System.out.println("文件拷贝完毕");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bos.close();
                bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    
}
