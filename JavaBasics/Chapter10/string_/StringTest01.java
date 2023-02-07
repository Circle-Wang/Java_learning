package Chapter10.string_;


// String类的内存创建
public class StringTest01 {
    public static void main(String[] args) {
        String a = "wyq";      // a指向的是常量池空间的地址
        String b = new String("wyq"); // b指向的是堆空间的地址

        System.out.println(a.equals(b)); // T string类的equals方法被重写过，用于不叫每个字符是否相等
        System.out.println(a == b);      // F
        // b.intern()将返回value的地址，即字符串常量在常量池中的地址(返回的是那个字符串)
        System.out.println(a.intern());
        System.out.println(a == b.intern()); // T
        System.out.println(b == b.intern()); // F

        System.out.println("===================");
        String a1 = "hello"; // 在常量池中创建一个字符串常量对象"hello"
        String b1 = "abc";   // 在常量池中创建一个字符串常量对象"abc"
        // 首先将创建一个StringBuilder对象 sb = new StringBuilder("hello")
        // 调用sb.append("abc"), 此时sb对象中已经有一个数组byte[]包含有"helloabc"
        // 最后调用sb.toString()方法，该方法会返回一个new String对象
        // 因此最后c1指向的是一个堆中的String对象，而该对象中的value指向的常量池中的"helloabc"
        String c1 = a1 + b1; 
        String d1 = "hello" + "abc"; // 这里d1将会直接指向变量池中
        String e1 = "helloabc";
        System.out.println(c1 == d1); // F
        System.out.println(c1.equals(d1)); // T
        System.out.println(d1 == e1); // T
    }
    
}
