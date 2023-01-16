package Chapter7;

import Chapter7.interface_.InterA;

public class InterfaceTest {
    public static void main(String[] args) {
        System.out.println(InterA.num);  // 证明是接口的属性都是static
        System.out.println("=============");

        InterClass interClass = new InterClass();
        new InterfaceTest().work(interClass); // 此处使用了多态的特性，


    }

    // 可以接收 实现了InterA的对象实例 (多态特性)
    public void work(InterA iA) {
        iA.hi();
    }
    
}

// InterClass实现了InterA接口
class InterClass implements InterA {
    @Override
    public void hi() {
        System.out.println("AA实现了InterA的hi()方法");
        
    }
}



