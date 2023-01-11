package Chapter6;

import Chapter6.poly_.Animal;
import Chapter6.poly_.Cat;
import Chapter6.poly_.Dog;

public class PolyTest {
    public static void main(String[] args) {
        Animal an = new Cat("小花");   // 向上转型。此时an的编译类型是Animal，运行类型是Cat 
        Object obj = new Cat("小白");  // 非直接子类也可以实现向上转型

        // 向上转型
        an.eat(); // 能够通过编译, 因为父类存在eat方法, 但执行的是子类中重写的eat()方法
        an.run(); // Animal跑, 可以直接使用父类方法(需要符合访问权限)

        // an.catchMouse(); // 编译无法通过，因为编译阶段只会编译类型(Animal)中存在的方法，因此无法访问子类特有的方法。
        // System.out.println(an.color); // 编译无法通过，同样的由于编译类型时Animal, 因此无法访问子类属性。

        // 向下转型
        Cat cat = (Cat) an;  // 将父类引用转化为子类运用. 要注意到此时an仍然指向堆中Cat对象。
        cat.catchMouse();    // 此时cat的编译类型是，运行类型也是Cat。
        System.out.println(cat.color); 
        System.out.println("==========="); 
        // Dog dog = (Dog) an; // 能够通过编译，但是运行时会抛出ClassCastException异常: 
        //                     // class Chapter6.poly_.Cat cannot be cast to class Chapter6.poly_.Dog


        // istanceOf比较操作符
        System.out.println("cat是否为Cat类型或为Cat的子类?: " + (cat instanceof Cat));
        System.out.println("cat是否为Animal类型或为Animal子类?: " + (cat instanceof Animal));
        System.out.println("obj是否为Animal类型或为Animal子类?: " + (obj instanceof Animal));
        System.out.println("obj是否为Cat类型或为Cat子类?: " + (obj instanceof Cat));



    }
    
}
