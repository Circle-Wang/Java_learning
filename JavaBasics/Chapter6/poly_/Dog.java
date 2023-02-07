package Chapter6.poly_;

public class Dog extends Animal{
    
    public Dog(String name) {
        super(name);
    }

    // 子类特有方法
    public void dogBark() {
        System.out.println("狗汪汪叫");
        
    }
    
}
