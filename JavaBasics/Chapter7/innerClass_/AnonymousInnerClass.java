package Chapter7.innerClass_;

public class AnonymousInnerClass {
    public static void main(String[] args) {
        Outer02 outer02 = new Outer02();
        outer02.m1();

    }
    
}


class Outer02 { // 外部类

    private int n1 = 100;

    public void m1() {
        
        // 匿名内部类实现接口
        // ia的编译类型是: IA   运行类型是: Outer02$1(由系统自动分配的名字)
        IA ia = new IA() {

            @Override
            public void ok() {
                System.out.println("这是匿名内部类实现的接口抽象方法OK");
                System.out.println("就近原则访问接口的IA的n1: " + n1);
                System.out.println("通过Outer02.this.n1访问外部类私有属性n1: " + Outer02.this.n1);
                
            }
            @Override
            public String hello(String str) {
                return "匿名内部类实现的有参抽象方法: " + str;
            }
            
        };  // 第一种调用方式使用引用接收实例地址
        ia.ok();
        ia.hello("一个参数");

        System.out.println("========继承父类的内部类==========");

        // 匿名内部类继承Father
        // 此时father的编译类型是: Father    运行类型是: Outer02$2(由系统自动分配的名字)
        Father father = new Father(){

            @Override
            public void hi() {  // 重写父类方法
                System.out.println("匿名内部类 hi() 被调用");
            }
        };
        father.hi(); // 会触发动态绑定

        // 第二种匿名内部类使用的方式。
        // 此时会触发父类构造器，由于匿名内部类没有重写父类的任何方法，所以会执行父类的hi()
        new Father("父类有参构造器需要的参数") {

        }.hi();

    }

}

// 外部接口
interface IA {

    public static final int n1 = 200;
    
    // 两个抽象方法
    void ok();
    String hello(String str);
}


// 外部其他类
class Father {
    
    public String name;

    // 父类有参构造器
    public Father(String name) {
        this.name = name;
        System.out.println("Father有参构造器被调用, 传入的参数为: " + this.name);
    }

    // 父类有参构造器
    public Father() {
        System.out.println("Father无参构造器被调用");
    }


    public void hi() {
        System.out.println("Father hi() 被调用");
        
    }

}