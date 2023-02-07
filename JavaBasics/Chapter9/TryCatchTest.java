package Chapter9;

@SuppressWarnings({"unused"})
public class TryCatchTest {
    public static void main(String[] args) {
        int n1 = 100;
        int n2 = 0;
        int n3;
        String str = "异常";

        try {
            n3 = n1/n2;   // 当n2=0时此处会出现ArithmeticException异常
            int a = Integer.parseInt(str);  // 此处会出现NumberFormatException异常
            System.out.println("接收的数字a是" + a);
        } catch (NumberFormatException e) {  // 可能出现多个异常，我们可以采用多个catch来捕获
            System.out.println("字符串转化出现异常" + e.getMessage());    
        } catch (ArithmeticException e) {  // 捕获顺序将根据异常出现的顺序
            System.out.println("计算出现异常:" + e.getMessage());
        } finally {
            System.out.println("finally代码块被执行");
        }

        System.out.println("====================");
        TryCatchTest a = new TryCatchTest();
        System.out.println(a.m1());
        
    }

    public int m1() {
        int n1 = 100;
        int n2 = 0;
        int n3;
        try {
            n3 = n1/n2;  
        } catch (ArithmeticException e) {  
            System.out.println("计算出现异常:" + e.getMessage()); 
            return 100;
        } finally {
            System.out.println("finally代码块被执行");
            return 200;   // 此时会覆盖catch中的return语句
        }
        // return 200;

    }

    
}
