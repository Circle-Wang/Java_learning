package Chapter6.modifier;

public class A {

    // 四个属性 不同的访问修饰符
    public int n1 = 100;
    protected int n2 = 200;
    int n3 = 300;
    private int n4 = 400;

    // 该方法可以访问四个属性
    public void m1() {
        System.out.println("n1=" + n1 + " n2=" + n2 + " n3=" + n3 + " n4=" + n4);
    }

    
}
