package Demo8;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintWriterTest {
    public static void main(String[] args) throws IOException {

        // 将打印位置重新定向
        PrintWriter pw = new PrintWriter(new FileWriter("Demo8/由PrintWriter打印.txt"));
        pw.println("你好打印机");
        pw.close();  // 如果不关闭则不会写入
    }
    
}
