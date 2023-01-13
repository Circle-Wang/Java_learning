package Chapter7;

import Chapter7.static_.A;
import Chapter7.static_.Student;

public class StaticTest {
    public static void main(String[] args) {
        System.out.println(A.name); // 没有生成对象即可访问.因为类变量是与类一起加载的
        System.out.println("---------");

        Student tom = new Student("tom");
        Student mary = new Student("mary");
        tom.payFee(100);
        Student.payFee(200);
        System.out.println(Student.fee);
        
    }
}
