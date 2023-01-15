package Chapter7;

public class CodeBlockTest02 {
    public static void main(String[] args) {
        new A();  // 先执行getN1，再执行静态代码块。
    }
    
}

class A {

    {
        System.out.println("A的普通代码块01"); // (4)
    }
    
    private static int n1 = getN1(); // (1)
    private int n2 = getN2(); // (3)


    
    static { // 静态代码块
        System.out.println("A的静态代码块01"); // (2)
    }

    public static int getN1(){
        System.out.println("getN1被调用");
        return 100;
    }

    public int getN2() {
        System.out.println("getN2被调用");
        return 100;
        
    }

    public A() {
        System.out.println("无参构造器被调用"); // (5)
    }

    
}


