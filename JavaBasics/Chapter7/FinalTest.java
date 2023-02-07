package Chapter7;

public class FinalTest {
    public static void main(String[] args) {
        FinalA finalA = new FinalA();
        System.out.println(finalA.TAX_RAT);
        System.out.println("=============");
        System.out.println(FinalD.TAX_RAT); // 此时使用final属性，不会导致static代码块的调用
        
    }
    
}

class FinalA {

    // 该属性无法被修改, 但可以被子类使用
    public final double TAX_RAT = 0.08;

    // 该方法无法被重写，但可以被继承使用
    public final void say() {
        // TAX_RAT = 1.1; // 无法被修改
        System.out.println("FinalA的say()方法");
    }

    public int addOne (final int x) {
        // 当调用方法时 会给x赋值
        // x++ // final修饰的变量无法修改
        return x + 1;

    }
}

@SuppressWarnings({"unused"}) // 忽略不使用的警告
class FinalB extends FinalA {
    
    public void hi() {
        final int n1 = 100; // 也称为局部常量
        // System.out.println(n1++); // 会报错
        System.out.println(super.TAX_RAT); // 可以使用父类的final属性
        
    }

}

class FinalC {
    // 非静态变量final赋值方式
    public final double TAX_RAT = 0.08;
    public final double TAX_RAT1;
    public final double TAX_RAT2;

    // 在构造器中赋值
    public FinalC() {
        TAX_RAT1 = 0.02;
    }

    // 在非静态代码块中赋值
    {
        TAX_RAT2 = 1.01;
    }
}

class FinalD {
    // 静态变量final赋值方式
    public static final double TAX_RAT = 0.08;
    public static final double TAX_RAT1;

    // 在静态代码块中赋值
    static {
        System.out.println("--FinalD的静态代码块--");
        TAX_RAT1 = 1.01;
    }

}
