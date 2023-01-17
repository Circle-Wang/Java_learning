package Chapter7.interface_;

// 公开接口b
public interface InterA {
    
    // 属性
    public String name = "";
    public int num = 1;   // 是public static final的


    // 抽象方法定义
    public void hi();

    // jdk8后可以有实现方法，但是需要使用default关键字修饰
    default public void ok() {
        System.out.println("接口的default实现方法体ok");
    }

    // jdk8后可以有静态方法
    public static void ddk() {
        System.out.println("接口的静态方法ddk");
    } 

}


// 普通类必须实现接口的所有抽象方法
class AA implements InterA {
    @Override
    public void hi() {
        System.out.println("AA实现了InterA的hi()方法");
        
    }
}

// 抽象类可以不用实现接口抽象方法
abstract class BB implements InterA {

}

