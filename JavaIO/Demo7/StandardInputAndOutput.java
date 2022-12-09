package Demo7;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class StandardInputAndOutput {
    public static void main(String[] args) throws IOException {
        
        // System.outs是PrintStream, 执行println
        PrintStream pr = System.out;
        pr.println("你好");

        // Scanner(扫描器)需要传入一个InputStream
        Scanner scanner = new Scanner(System.in, "GBK");  // 采用这种方式无法输入中文, 因为我们是采用的GBK方式输入，因此读取的字节码是按照GBK的方式读取的
        System.out.println("你的输入是: " + scanner.nextLine());  // 开始阻塞

        // 扫描器输入可以其FileInputStream对象
        FileInputStream fis = new FileInputStream("Demo7/GKB编码文档.txt");
        Scanner scanner2 = new Scanner(fis, "GBK");
        System.out.println(scanner2.nextLine());


        scanner.close();
        scanner2.close();
    }
    
}
