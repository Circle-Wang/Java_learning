package Demo10;

/*
 * 不是所有类都需要public static void main，一般来说一个项目只需要一个启动类
 * this关键字, 相当于python中的self, 表示当前实例。
 * this(): 执行当前类的无参构造函数
 * 
 * 构造方法: 1、必须和类的名字相同。
 *          2、不能有返回值，因此连void也没有。
 *          3、每个类创建时都有一个默认的构造方法。
 *          4、构造函数可以重载（有参构造和无参构造）
 * 构造方法的作用: 初始值设定
 * 
 * new的本质是在调用构造方法
*/

public class Student {

    // 属性
    String name;  // 默认是null
    int age;      // 默认是0

    // 无参构造函数
    public Student(){

    }

    // 有参构造: 一旦定义了有参构造，无参构造必须显式定义(否则无法使用无参构造的方式创建对象), 其实就是方法的重载
    public Student(String name){
        this.name = name;
    }

    // 方法
    public void study() {
        System.out.println(this.name+"在学习");
        
    }
}
