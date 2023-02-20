package Demo4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterTest {

    public static void main(String[] args) {
        BufferedWriter bw = null;

        try {
            bw = new BufferedWriter(new FileWriter("Demo4/测试写入.txt"));
            bw.write("我希望你能柔和\n");
            bw.newLine();  // 插入换行符
            char[] chars = {'又','充','满','力','量'};
            bw.write(chars);
            bw.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
}
