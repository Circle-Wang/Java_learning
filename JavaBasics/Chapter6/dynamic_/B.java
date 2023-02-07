package Chapter6.dynamic_;

public class B extends A{
    public int i = 20;

    // public int sum() {
    //     System.out.println("子类sum被调用");
    //     return getI() + 10;
    // }

    // public int sum1() {
    //     System.out.println("子类sum1被调用");
    //     return i + 10;
    // }

    public int getI() {
        System.out.println("子类中的getI方法被call");
        return i;
    }

    
}
