package Demo5;


import java.io.Serializable;


public class Dog implements Serializable{

    private int age;
    private String name;
    private static String color = "白色"; // static不会被序列化

    // serialVersionUID序列化的版本号，可以提高兼容性
    private static final long serialVersionUID = 1L;

    
    // 构造函数
    public Dog(int age, String name) {
        this.age = age;
        this.name = name;
    }

    // 一些方法
    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public static String getColor() {
        return color;
    }

    // 重写toString方法让其可以打印消息
    @Override
    public String toString() {
        return "Dog [age=" + age + ", name=" + name + "]" + "我爱你";
    }

    // 调用自己的方法
    public void myPrint(){
        System.out.println("打印一句话");
    }

}
