package Chapter7.static_;

public class A {

    public static String name = "A类的静态变量";
    private int age;

    public static void hi() {
        // 能访问静态方法
        wow();
        // say(); // 不能访问非静态方法

        // 两种访问类变量的方式
        System.out.println(name);
        System.out.println(A.name);
        
    }

    public static void hello() {
        System.out.println("父类的静态方法hello被调用");
        
    }

    public void say() {
        System.out.println("非静态方法say");
        wow(); // 可以访问静态方法
        System.out.println(A.name); // 可以访问静态成员
    }

    public static void wow() {
        System.out.println("静态方法wow");
    }
    
}

