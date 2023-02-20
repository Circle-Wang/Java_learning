package Chapter13;

public class Dog{
    public String name = "小狗";
    public int age = 12;

    
    public Dog() {
    }

    public Dog(String name) {
        System.out.println("Dog有参构造器被调用");
        this.name = name;
    }

    public void cry() {
        System.out.println("小狗汪汪叫");
    }

    public String m1() {
        System.out.println("Dog的m1被调用");
        return null;
    }

}
