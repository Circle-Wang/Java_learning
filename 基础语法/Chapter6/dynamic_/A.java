package Chapter6.dynamic_;

public class A {
    public int i = 10;

    public int sum() {
        System.out.println("父类sum被调用");
        return getI() + 10;
    }

    public int sum1() {
        System.out.println("父类sum1被调用");
        return i + 10;
    }

    public int getI() {
        System.out.println("父类中的getI方法被call");
        return i;
    }
    
}
