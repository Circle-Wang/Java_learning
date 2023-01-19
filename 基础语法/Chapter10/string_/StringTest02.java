package Chapter10.string_;

public class StringTest02 {
    public static void main(String[] args) {
        String a = "hello";   // a指向常量池的"hello"
        String b = "abc";     // b指向常量池的"abc"
        String c = "helloabc"; // c指向常量池的"helloabc"
        String e = a + b;     // 由于是字符串对象相加，依然会产生StringBuilder, 
                              // 最终e指向堆中的String对象
        String f = (a + b).intern(); // f指向常量池的"helloabc"

        System.out.println(e == c); // F
        System.out.println(f == c); // T
        System.out.println("====================");

        // 字符串格式化输出
        String formaString = "我的姓名是%s, 年龄是%d, 成绩是%.2f, 性别是%c";
        String info = String.format(formaString, "wyq", 21, 99.56542, '男');
        System.out.println(info);


    }
    
}
