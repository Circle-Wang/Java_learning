package Chapter6;

public class ExtendTest {
    public static void main(String[] args) {
        MiddleStudent student = new MiddleStudent();

        // student.num; // 通过创建子类对象无法访问父类的protected属性

        student.testing(); // 子类的特有方法
        
        System.out.println(student.getScore()); // 调用父类的public方法(尽管子类并没有写这个方法)，可以访问到父类的私有属性
        
    }
    
}
