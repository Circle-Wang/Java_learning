package Chapter6;

import Chapter6.extend_.Student;

// 这是Student基类的包外子类
public class MiddleStudent extends Student{

    public static void main(String[] args) {
        MiddleStudent student = new MiddleStudent();

        // 在子类方法中可以访问到父类的protected属性
        System.out.println("父类公共属性name: " + student.name + " 父类protected属性num: " + student.num);
    }

    public void testing() {
        num = 123;  // 可以使用(相当于自己的一个属性)父类的protected属性
        System.out.println("中学学生学号为 " + this.num + "正在考中学数学..."); 
        
    }

    
    

}
