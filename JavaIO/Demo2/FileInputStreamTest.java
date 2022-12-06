package Demo2;

import java.io.FileInputStream;
import java.io.IOException;


public class FileInputStreamTest {

    public static void main(String[] args) {

        int readData = 0;
        FileInputStream fileStream1 = null;
        FileInputStream fileStream2 = null;

        try {
            // 从磁盘中读取数据因此使用Input流
            fileStream1 = new FileInputStream("Demo2/hello.txt");
            
            // 方法一: 使用 对象.read()从该输入流中读取一个字节的数据
            while ((readData = fileStream1.read()) != -1) {
                System.out.print((char) readData);
            }
            System.out.println("\n==========");


            // 方法二: 使用 对象.read(byte[] b)的方法来一次读取多个字节
            fileStream2 = new FileInputStream("Demo2/hello.txt"); // 重新赋值
            byte[] buffer = new byte[9];   // 一次读取9个字节
            int readLen = 0;
            while ((readLen = fileStream2.read(buffer)) != -1) {
                System.out.println(readLen);
                System.out.println(new String(buffer,  0, readLen)); // 这里需要使用readLen限制转化为字符串的byte数组长度,最后一次readLen=3
            }
            System.out.println("\n==========");


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 如果不关闭流对象, 则会一直连接该文件
            try {
                fileStream1.close();
                fileStream2.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        
    }
    
}
