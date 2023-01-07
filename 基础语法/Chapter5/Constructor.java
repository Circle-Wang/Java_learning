package Chapter5;

public class Constructor {
    public static void main(String[] args) {

        // 在创建对象时调用构造器，完成对象属性的初始化。
        Person2 p1 = new Person2("小王", 13);
        System.out.println("p1对象的hashCode: " + p1.hashCode());
        System.out.println("p1的name为: "+ p1.name + " p1的age为: " + p1.age );
        
        
        
    }
    
}

class Person2 {

    String name;
    int age;

    public Person2(String pName, int pAge) {
        this.name = pName;  
        this.age = pAge;
        
        System.out.println("Person2的构造器被调用");
        System.out.println("构造器中this的hashCode: " + this.hashCode());
    }

    // 这是一个无参构造器
    public Person2() {
        // 在构造器中调用Person2的有参构造器
        this("小名", 12);  // 在一个构造器中访问另一个构造器的唯一方法。并且该语句必须放在第一条语句
        System.out.println("使用this访问了Person2的另一个构造器");
    }


    

    
}
