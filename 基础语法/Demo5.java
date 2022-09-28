package 基础语法;
import java.util.Scanner;

public class Demo5 {
    public static void main(String[] args) {

        // 创建一个Scanner对象,用于接收键盘数据
        Scanner scanner = new Scanner(System.in,"UTF-8");
        System.out.println("用户输入:");

        // 判断用户有无字符串输(会阻塞)
        if (scanner.hasNext()){
            // 接收用户输入
            String strs = scanner.next(); // 会以空格分割,如果想输出一行则使用netLine(),使用hasNextLine()判断时候是否存在数据
            System.out.println("用户输入为: "+strs);
        }
        
        // scanner还有nextInt(),nextFloat()等等来判断输入类型

        // 实于IO流的类使用结束需要关闭?
        scanner.close();
    }
}
