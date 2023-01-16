package Chapter7;


public class AbstractTest {
    
}

// 一个抽象类(无法被实例化)
abstract class AbstractA {

    // 包含一个类的所有内容
    private int n1;
    public static String name;

    // 可以包含构造器
    public AbstractA() {
    }
    public AbstractA(int n1) {
        this.n1 = n1;
    }

    // 抽象方法
    public abstract void hi();

    // 非抽象方法
    public void say() {
        System.out.println("抽象类中非抽象方法");
    }
}

// 不包含抽象方法的抽象类
abstract class AbstractB {

}

// 继承自抽象类的子类
class AbstractC extends AbstractA {

    // 需要实现抽象类的所有抽象方法
    @Override
    public void hi() {
        
    }
    
}

// 子类也是抽象类则无需重写父类抽象方法
abstract class AbstractD extends AbstractA {

    // 子类又增加了一个抽象方法
    public abstract void hiD(); 
    
}

class AbstractE extends AbstractD {

    // 需要重写直接父类和超类的抽象方法
    @Override
    public void hiD() {
           
    }

    @Override
    public void hi() {
        
    }

    
}