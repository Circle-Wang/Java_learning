package Chapter6.poly_;

public class Animal {

    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public void run() {
        System.out.println("Animal跑");
        
    }

    public void sleep() {
        System.out.println("Animal睡觉");
        
    }

    public void eat() {
        System.out.println("Animal吃食物");
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
