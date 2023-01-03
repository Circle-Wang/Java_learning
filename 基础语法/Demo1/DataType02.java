package Demo1;

public class DataType02 {
    public static void main(String[] args) {
        // 整数拓展: 二进制0b开头, 八进制0开头, 十六进制0x开头
        int i = 10;
        int i2 = 010;
        int i3 = 0xf;  // 表示十六进制的15, A-F
        System.out.println("i3为: "+i3);

        //  \t:制表符  \n:换行
        System.out.println("hello,\nworld");
        System.out.println("====================");

        // 强制类型转换
        int in = 65;
        byte b = (byte) in;     // 强制类型转换
        double D = in;          // 由低转换到高, 自动转换
        char A_in = (char) in;  // 将int转化为字符
        char B_in = (char) (in + 1);
        System.out.println(B_in);
        System.out.println("====================");

        // 大数内存溢出问题(低位与高位运算会自动往高位转换，但低位与低位运算会出现内存溢出)
        int money = 10_0000_0000;
        int year = 20;
        long total = money * (long) year;
        System.out.println(total);
        System.out.println("====================");

        // 浮点数计算后的值不能直接使用==来判断相等(浮点数计算后是估计值)
        // 使用差值误差来判断
        double n1 = 8.1 / 3;
        double n2 = 2.7;
        if (Math.abs(n1-n2) < 1e-5){
            System.out.println(n1);
            System.out.println("n1和n2数相等");
        }

        // byte、short、char可以进行运算，在运算(单种运算/混合运算)时会将所有数值变为int
        byte b1 = 10;
        byte b2 = 2;
        short s1 = 12;
        // short s2 = s1 + b1; // 此处会报错，因为byte和short运算，结果会自动提升成int
        // byte b3 = b1 + b2; // 此处会报错，就算byte和byte运算，结果也会自动提升成int
        

    }
}
