package Chapter6;

import Chapter6.extend_.Student;

public class ExtendTest {
    public static void main(String[] args) {
        MiddleStudent student = new MiddleStudent();

        // student.num; // 通过创建子类对象无法访问父类的protected属性

        student.testing(); // 子类的特有方法
        
        System.out.println(student.getScore()); // 调用父类的public方法(尽管子类并没有写这个方法)，可以访问到父类的私有属性
        
    }
    
}


// 这是Student基类的包外子类
class MiddleStudent extends Student{

    public static void main(String[] args) {
        MiddleStudent student = new MiddleStudent();

        // 在子类方法中可以访问到父类的protected属性
        System.out.println("父类公共属性name: " + student.name + " 父类protected属性num: " + student.num);
    }

    public void testing() {
        // super.type; // 在其他包无法访问父类的默认/private权限的属性
        num = 123;  // 可以使用(相当于自己的一个属性)父类的protected属性
        System.out.println("中学学生学号为 " + this.num + "正在考中学数学..."); 
        
    }
}