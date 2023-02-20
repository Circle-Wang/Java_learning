package Demo3;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterTest {
    public static void main(String[] args) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("Demo3/Writerx写入的文件.txt");
            fileWriter.write("H");

            char[] chrs = {'你','好','s'};
            fileWriter.write(chrs);

            fileWriter.write("成功学教育".toCharArray(), 0, 3);

            fileWriter.write(" 上海天津", 0, 3);


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
    
}
