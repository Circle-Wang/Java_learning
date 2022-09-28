package Demo10;

/*
Student类
静态方法(static): 与类一起加载的，因此static方法的方法在类里可以被任意其他方法(静态或非静态)调用
非静态方法: 与对象实例一起加载的，因此非静态方法无法在static方法中直接被调用，因为static方法被使用时非静态方法还不存在，需要先创建实例再使用。
但非静态方法之间可以互相调用
*/


public class Demo10 {
    public static void main(String[] args) {

        method1();              // 直接使用
        new Demo10().method2(); // 先实例化在使用
        System.out.println("===================");

        Student xm = new Student("小明");
        Student xh = new Student("小红");
        xm.name = "小明";
        xm.age = 12;

        xh.name = "小红";
        xh.age = 15;
        System.out.println(xm.name + "的年纪为: " + xm.age);

        
    }

    // 静态方法: 在其他类的代码中可以使用Demo10.method1()直接调用
    public static void method1() {
        System.out.println("调用了Demo10中的method1方法");
        
    }

    // 非静态方法: 需要先new Demo10(), 再使用实例名.methcod2()
    public void method2(){
        System.out.println("调用了Demo10中的method2方法");
    }
    
}
