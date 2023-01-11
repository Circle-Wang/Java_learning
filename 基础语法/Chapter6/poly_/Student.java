package Chapter6.poly_;

public class Student extends Person {

    private double score;

    public Student(String name, int age, double score) {
        super(name, age);
        this.score = score;
    }

    public String say() {
        return "学生: "+ super.say() + "\t成绩=" + score;
        
    }

    // 子类特有方法
    public void study() {
        System.out.println("学生 " + getName() + " 正在学习");
        
    }
    
    
}
