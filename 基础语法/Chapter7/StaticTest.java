package Chapter7;

import Chapter7.static_.A;
import Chapter7.static_.B;
import Chapter7.static_.Student;

public class StaticTest {
    public static void main(String[] args) {
        System.out.println(A.name); // 没有生成对象即可访问.因为类变量是与类一起加载的
        System.out.println("================");

        // 对象共用一个静态属性
        Student tom = new Student("tom");
        Student mary = new Student("mary");
        tom.payFee(100);
        Student.payFee(200);
        System.out.println(Student.fee);
        System.out.println("=============");

        // 对静态方法的重写
        B b1 = new B();
        B.hello();
        b1.hello();
        A b2 = new B(); // 向上转型
        b2.hello(); // 调用的是A类的静态方法
        

        
    }
}
