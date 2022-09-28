package 基础语法;
/**
 * 运算符: 或:|| 与:&& 非:!
 * 位运算: 或:| 与:& 异或:^
 * +连接符: 如果+两边出现string类型，则+改变为连接字符串的符号。如果有多个+则从左往右运算。
 * 三元运算符: x ? y : z  表示如果x=true则结果为y, 否则结果为z
 * 
 * */ 

public class Demo4 {
    public static void main(String[] args) {
        // int a = 2;
        // int b = a++; // 先赋值再自增，即 b = a; a += 1
        // int c = ++a; // 先自增再赋值，即 a += 1; c = a
        // Math.pow(3,2);
        // System.out.println(a);
        // System.out.println(b);
        // System.out.println(c);
        // System.out.println("================");

        // int a = 10;
        // int b = 20;
        // System.out.println(""+a+b);  // 会得到1020
        // System.out.println(a+b+"");  // 会得到30
        // System.out.println("================");

        int score = 80;
        String result = score >= 80 ? "及格":"不及格";
        System.out.println(result);
        System.out.println("================");

    }
}
