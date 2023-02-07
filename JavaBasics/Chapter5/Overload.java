package Chapter5;
public class Overload {
    public static void main(String[] args) {
        double sum1 = add(1.1, 2.2);
        int sum2 = add(1, 2);

        // 可变参数的调用
        add(1,2,3,4);
        add(new int[]{9,100,1});

        System.out.println("sum1为:" + sum1 +"\t" + "sum2为:" + sum2);
    }

    // 加法方法
    public static int add(int a, int b) {
        return a+b;
    }

    // 重载(形参个数,类型,类型顺序不同即为重载)
    public static double add(double a, double b) {
        return a+b;
    }

    // 可变参数(不定向参数)在类型后加...
    // 一个方法中只能指定一个可变参数, 并且普通参数必须在可变参数之前声明
    // numbers会作为一个数组被传入函数中，可以是0个参数，也可以是多个参数传入。
    private static double add(int... numbers) {
        double res = 0;
        for (int i:numbers){
            res += i;
            System.out.println(i);
        }
        System.out.println("====可变参数方法计算完毕====");
        return res;
    }
}
