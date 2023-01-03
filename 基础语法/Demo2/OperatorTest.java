package Demo2;

/**
 * 运算符: 或:|| 与:&& 非:!
 * 位运算: 或:| 与:& 异或:^
 * +连接符: 如果+两边出现string类型，则+改变为连接字符串的符号。如果有多个+则从左往右运算。
 * 三元运算符: x ? y : z  表示如果x=true则结果为y, 否则结果为z
 * 
 * */ 

public class OperatorTest {
    public static void main(String[] args) {

        // 算数运算符号
        System.out.println(10/4);  // 由于10/4计算结果会保存在int，因此得出的结果会保留精度为整数
        System.out.println(10/4.0); // 此处答案正确2.5
        double d1 = 10/4; // 此处d的值为2.0
        System.out.println(d1);
        System.out.println("-10 % 3的答案是: " + (-10 % 3)); 
        System.out.println("10 % -3的答案是: " + (10 % -3)); // 10 - 10 / (-3) * (-3)
        System.out.println("================");

        // 自增面试题目
        int i1 = 1;
        i1 = i1++; // 底层执行顺序(1) temp = i1 (2) i1 = i1 + 1 (3) i1 = temp
                   // 后++表明先参与其他运算再进行自增操作，但注意自增是结果，参与运算的其实是在自增前就被保留下来数值的另一个临时变量
                   // 其中(3)就是在参与运算
        System.out.println("最后i1的结果为: " + i1);
        int i2 = 1;
        i2 = ++i2; // (1)i2 = i2 + 1 (2)temp = i2 (3) i2 = temp
        System.out.println("最后i2的结果为: " + i2);
        System.out.println("================");


        // 逻辑与算法符
        int a = 4;
        int b = 20;
        if (a < 1 && ++b < 50) {
            System.out.println("短路与判断为真");
        }
        System.out.println("a=" + a + " b=" + b); // 由于短路与，当a<1时整个逻辑判断已经能知道答案了，因此后面的++b<50不会执行

        if (a < 1 & ++b < 50) {
            System.out.println("逻辑与判断为真"); // 逻辑与，当a<1时整个逻辑判断已经能知道答案了，但后续判断仍会执行续++b<50
        }
        System.out.println("a=" + a + " b=" + b);
        System.out.println("================");

        // 三元运算符
        int score = 80;
        String result = score >= 80 ? "及格":"不及格";
        System.out.println(result);
        System.out.println("================");

    }
}
