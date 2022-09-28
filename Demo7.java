public class Demo7 {
    public static void main(String[] args) {
        double sum = add(1,2);

        method(1,2,3,4);
    }

    // 加法方法
    public static int add(int a, int b) {
        return a+b;
    }

    // 重载(方法名相同,参数个数,类型,类型顺序不用即为重载)
    public static double add(double a, double b) {
        return a+b;
    }

    // 可变参数(不定向参数)在类型后加...
    // 一个方法中只能指定一个可变参数, 并且普通参数必须在可变参数之前声明
    // numbers会作为一个数组被传入函数中
    private static void method(int... numbers) {
        for (int i:numbers){
            System.out.println(i);
        }
    }
}
