package Demo1;

public class StringToBasic {

    public static void main(String[] args) {

        // 基本数据类型转化为字符串
        int n1 = 100;
        float n2 = 1.2f;
        boolean b1 = true;
        double d1 = 1.32;
        
        String s1 = n1 + "";
        String s2 = n2 + "";
        String s3 = b1 + "";
        String s4 = d1 + "";
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);
        System.out.println("================");

        // +符号连接字符串实例
        int a = 10;
        int b = 20;
        System.out.println(""+a+b);  // 会得到1020
        System.out.println(a+b+"");  // 会得到30
        System.out.println("================");



        // 字符串转为基本数据类型
        int num1 = Integer.parseInt(s1);
        float num2 = Float.parseFloat(s2);
        double num3 = Double.parseDouble(s4);
        boolean num4 = Boolean.parseBoolean(s3);
        System.out.println(num1);
        System.out.println(num2);
        System.out.println(num3);
        System.out.println(num4);

        // 字符串转为char的操作是将字符串中的某个字符取出来
        System.out.println("1234".charAt(0));


    }
    
}
