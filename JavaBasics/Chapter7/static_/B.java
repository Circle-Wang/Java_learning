package Chapter7.static_;

public class B extends A {

    // 试图重新父类的静态方法(实际调用时父类的将会被隐藏)
    public static void hello() {
        System.out.println("子类的静态方法hello被调用");
        
    }
    
}
