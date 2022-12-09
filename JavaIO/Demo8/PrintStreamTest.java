package Demo8;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class PrintStreamTest {
    public static void main(String[] args) throws IOException {
        // System.out是标准输出，默认输出到显示器
        PrintStream out = System.out;
        out.print("你好啊"); // 由于print底层调用的是write,但write是将字节打印出去
        out.print("============");
        out.write("打印的字节数组".getBytes("GBK"));
        out.close();

        // 修改打System.out的打印位置，则System.out.print则会输出到文件中
        System.setOut(new PrintStream("Demo8/由PrintStream打印的.txt"));
        System.out.print("由System.out打印来的");

        // 也可以这样构造一个打印流
        PrintStream ps= new PrintStream(new FileOutputStream("Demo8/由PrintStream打印的.txt",true));
        ps.print("由另一个PrintStream输入的");
        ps.close();
    }

}
