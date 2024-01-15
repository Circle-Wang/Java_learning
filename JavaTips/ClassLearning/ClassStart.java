
// package ClassStart;

public class ClassStart {

    public static void main(String[] args) {
        System.out.println(("开始new A()"));
        new A();
        System.out.println("new A() 结束");

        try {
            Class<?> B_Class = Class.forName("B");
        } catch(ClassNotFoundException e) {
            System.out.println("没有找到B");
        }
        System.out.println("已完成 Class.forName(\"B\")");

        System.out.println(("开始C.Class"));
        Class<?> C_Class = C.class;
        System.out.println(("已完成C.Class"));
    }
}

class A {
  static {   System.out.println("JVM Loading A"); }
}

class B {
  static {   System.out.println("JVM Loading B"); }
}

class C {
  static {   System.out.println("JVM Loading C"); }
}