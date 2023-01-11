package Chapter6.poly_;

public class Cat extends Animal{

    public String color = null;
    
    public Cat(String name) {
        super(name);
    }

    // 子类特有方法
    public void catchMouse() {
        System.out.println("猫抓老鼠");
        
    }

    // 重写父类方法
    public void eat() {
        System.out.println("猫吃鱼");
    }
    
}
