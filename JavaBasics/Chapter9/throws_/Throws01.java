package Chapter9.throws_;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Throws01 {
    public static void main(String[] args) {
        
        try {
            f1(); // 此时main就是调用者，所以这里我们必须处理接收f1()抛出的异常
                  // 当然我们也可以不使用try-catch，也使用throws将异常抛出
        } catch (FileNotFoundException | NullPointerException e) {
            e.printStackTrace();
        }
    }

    // 可以抛出多个异常
    public static void f1() throws FileNotFoundException, NullPointerException { // 此处直接写Exception(是其的父类)
        // FileNotFoundException是一个编译时异常(我们必须要处理)
        // 1)使用try-catch处理
        // 2)使用throws抛出异常, 让调用f1()方法的调用者处理
        FileInputStream fis = new FileInputStream("一个存在的路径");
    }
    
}
