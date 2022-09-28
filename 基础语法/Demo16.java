/*
 * Exception: 异常
 * Java中定义了许多异常类，通常分为错误Error和Exception
 * 
 * Error：
 *  - 由Java虚拟机生成并抛出，大多数错误与代码编写者所执行的操作无关
 * Exception：
 *  - 常用的重要子类:RuntimeException
 *  - 数组下标异常、算术异常、...
 *  - 通常情况下可以被程序处理
 * 
 * 异常处理的常用关键字：
 *  - try：try中的代码块会被监控出现了那些异常。并根据异常来分支处理。
 *  - catch：中参数表示想要捕获的异常类型，可以是Exception，Error，Throwable，或者某些特定异常。可以多catch多个异常，但异常范围需要从小到大的捕获。
 *  - finally：无论try中是否发生异常，都会执行这一步
 *  - throw：常用于方法体中，面对我们可以预计的异常，主动抛出，停止之后后续代码。如果异常对象是非 RuntimeException 则需要在方法申明时加上该异常的抛出 即需要加上 throws 语句 或者 在方法体内 try catch 处理该异常，否则编译报错
 *  - throws：方法的定义上使用 throws 表示这个方法可能抛出某种异常.
*/
public class Demo16 {

    public static void main(String[] args) { 

        int a = 1;
        int b = 0;
        try {   // 监控区域

            // 主动抛出异常, 当程序进入throw时，将抛出异常不会再执行后续代码。
            if (b == 0){
                throw new ArithmeticException();
            }

            System.out.println("进入计算"); // 由于前序代码已经被抛出异常了，因此不会被执行。 
            System.out.println(a/b);
        } catch (ArithmeticException e) {
            System.out.println("程序出现了ArithmeticException异常");
            e.printStackTrace(); // 打印栈信息

        } catch (Exception e) {  // 若捕获了异常，则执行catch中内容，Exception是指任意的异常类，我们可以指定特殊的异常(ArithmeticException)。
            System.out.println("程序出现异常");
        } finally {
            System.out.println("无论是否出现异常都会执行finally");
        }
        
    }

    public void test(int a, int b) throws Exception{
            
    }
    
}
