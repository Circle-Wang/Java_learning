package Demo11;
/*
 * 对于类定义中的修饰词一共有三种: 
 *      private: 只可以被自己的类访问，子类也无法访问。
 *      不添加修饰词: 可以被自己类访问，或者同一个包的类访问，但不能被子类访问
 *      protected: 可以被自己类访问，可以被同一个包的类访问，或者被子类访问。
 *      public: 可以被任意访问。
 * 
 * 对于私有属性常常需要增加set/get方法使得可以该属性被外部访问。增加set/get方法主要作用是可以对用户操作进行限制，例如age需要在某一个范围内才能作为合法输入。
*/


public class Person {

    public String name;
    private int age;


    public Person(){
        System.out.println("Person的无参构造函数被执行");
    }

    // 通过该方法访问私有属性age
    public int getAge() {
        return age;
    }

    // 通过该方法修改/初始化私有属性age
    public void setAge(int age) {
        this.age = age;
    }

    public void shout(){
        System.out.println("Person类的shout方法");
    }
    
}
