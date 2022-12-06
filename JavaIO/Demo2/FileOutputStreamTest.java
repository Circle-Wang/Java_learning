package Demo2;

import java.io.File;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamTest {

    public static void main(String[] args) {
        FileOutputStream fileOS = null;
        File file = new File("Demo2/hello_new.txt");

        try {
            fileOS = new FileOutputStream(file, true);  // 若不存在会自动创建文件，也会默认覆盖
            // 写入一个字节
            fileOS.write('a');  // 可以直接给char 也可以给int(但是需要小于128)会根据ASCII码转化为对应字符的

            // 写入字符串
            String str = "你好hello,world!\n";
            fileOS.write(str.getBytes());

            // 写入字符串，方法二
            String str2 = "这是第二句话abc";
            fileOS.write(str2.getBytes(), 0, 9); // 只写入指定字节长度的数据


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileOS.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
}
