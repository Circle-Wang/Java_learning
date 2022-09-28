package Demo13;
/*
 * 继承：extends关键字来表示该类继承于谁
 * 
 * super关键字: 对于父类中可以被子类看到的属性/方法，我们可以使用 super.属性名/方法名 对父类方法进行访问
 * 构造: 子类的构造函数会自动首先执行父类的构造函数(即:super()) 
*/


public class Teacher extends Person {

    // 当前类的无参构造函数
    public Teacher(){
        // 这里隐藏了super();
        System.out.println("Teacher类的无参构造函数被执行");
    }

    public void shout(){
        // super.shout();   // 调用父类的方法
        System.out.println("Teacher类的shout方法");
    }
    
}
