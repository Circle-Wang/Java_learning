package Chapter5;

public class Constructor {
    public static void main(String[] args) {

        // 在创建对象时调用构造器，完成对象属性的初始化。
        Person2 p1 = new Person2("小王", 13);
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
    }


    
}
