package Chapter9;

// 对异常练习题
public class Exercise01 {
    public static void main(String[] args) {
        
        try {
            if (args.length != 2) {
                throw new ArrayIndexOutOfBoundsException("命令行参数不等于2");
            }
            int num1 = Integer.parseInt(args[0]);
            int num2 = Integer.parseInt(args[1]); // 此处可能抛出NumberFormatException异常
            double res = cal(num1, num2); // 此处可能会抛出一个ArithmeticException异常
            System.out.println("计算结果是: " + res);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage()); // 这里得到的就是字符串"命令行参数不等于2"
        } catch (NumberFormatException e) {
            System.out.println("字符串转化数值异常: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("除以0异常: " + e.getMessage());
        }
                
    }

    public static double cal(int n1, int n2) {
        return n1/n2;
    }
    
}
