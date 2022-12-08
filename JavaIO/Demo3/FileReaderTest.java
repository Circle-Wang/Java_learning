package Demo3;

import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest {



    public static void main(String[] args) throws IOException {
        
        FileReader fReader1 = null;
        FileReader fReader2 = null;

        try {
            fReader1 = new FileReader("Demo2/hello.txt");
            fReader2 = new FileReader("Demo2/hello.txt");

            // 读取方式1: 使用字符数组
            char[] buffer = new char[8]; // 每次读取8个字符
            int bufferLen = 0;
            while ((bufferLen = fReader2.read(buffer)) != -1) {
                System.out.println(new String(buffer, 0, bufferLen));
            }

            System.out.println("\n ===============");

            // 读取方式2: 使用单个字符读取
            int data = 0 ;
            while ((data = fReader1.read()) != -1) {
                System.out.print((char) data);
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            fReader1.close();
            fReader2.close();
        }
    }
    
}
