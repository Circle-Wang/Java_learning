package Chapter6;

import Chapter6.dynamic_.A;
import Chapter6.dynamic_.B;

public class DynamicTest {
    public static void main(String[] args) {
        A a = new B();
        // 由于B类中没有sum方法, 因此执行的是父类A中的sum()
        // 但当执行到A.sum()方法的第二行getI()时，触发动态绑定机制，此时jvm会查找运行类型中是否有getI()
        // 发现运行类型B中存在getI()方法，因此A.sum()方法的第二行执行的是B的getI()
        // 由于属性没有动态绑定机制，因此B.getI()的返回值i就是根据就近原则返回即可，即返回20.
        System.out.println(a.sum() + "\n==========");  // 最终运行结果是20+10

        // 由于B类中存在sum1方法(重写), 因此直接执行B类中的sum1()方法
        System.out.println(a.sum1()); // 30

        // 若把B类中的sum1方法删除，此时调用的将会是A中的sum1()方法
        // 由于属性没有动态绑定机制，因此A中的sum1()方法返回10(a的属性)+10
        System.out.println(a.sum1()); // 20
    }
    
}
