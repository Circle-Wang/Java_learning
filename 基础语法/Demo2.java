public class Demo2 {
    public static void main(String[] args) {
        // 整数拓展: 二进制0b开头, 八进制0开头, 十六进制0x开头
        int i = 10;
        int i2 = 010;
        int i3 = 0xf;  // 表示十六进制的17, A-F
        System.out.println(i3);

        //  \t:制表符  \n:换行
        System.out.println("hello,\nworld");
        System.out.println("====================");

        // 强制类型转换
        int in = 65;
        byte b = (byte) in;     // 强制类型转换
        double D = in;          // 由低转换到高, 自动转换
        char A_in = (char) in;  // 将数字转化为字符
        char B_in = (char) (in + 1);
        System.out.println(B_in);
        System.out.println("====================");

        // 大数内存溢出问题(低位与高位运算会自动往高位转换，但低位与低位运算会出现内存溢出)
        int money = 10_0000_0000;
        int year = 20;
        long total = money * (long) year;
        System.out.println(total);
        

    }
}
