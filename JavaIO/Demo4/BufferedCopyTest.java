package Demo4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedCopyTest {
    public static void main(String[] args) {
        BufferedWriter bw = null;
        BufferedReader br = null;
        
        try {
            bw = new BufferedWriter(new FileWriter("Demo4/测试写入_复制.txt"));   // 复制的目标路径
            br = new BufferedReader(new FileReader("Demo4/测试写入.txt"));   // 源文件路径
            String readData = "";
            while ((readData = br.readLine()) != null) {
                bw.write(readData);
                bw.newLine(); // 此处需要增加一个换行符
            }
            System.out.println("复制成功");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
