package Chapter6.poly_;

public class Teacher extends Person{

    private double salary;

    public Teacher(String name, int age, double salary) {
        super(name, age);
        this.salary = salary;
    }

    // 重写父类方法
    public String say() {
        return "老师: " + super.say() + "\t薪水=" + salary;
    }

    // 子类特有方法
    public void teach() {
        System.out.println("老师 " + getName() + "正在教授java");
        
    }
    
}
