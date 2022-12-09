package Demo7;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;


public class OutputStreamWriterTest {
    public static void main(String[] args) throws IOException {
        OutputStreamWriter gbkWriter = new OutputStreamWriter(new FileOutputStream("Demo7/生成GBK编码文档.txt"), "GBK");
        gbkWriter.write("君子慎独,不欺暗室\n");
        gbkWriter.write("这是GBK编码");


        gbkWriter.close();
    }
    
}
