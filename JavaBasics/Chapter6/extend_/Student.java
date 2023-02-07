package Chapter6.extend_;

// 这是父类(基类)
public class Student {
    
    public String name;
    public int age;
    private double score;
    protected int num;
    protected String type = "人"; 

    
    
    public Student() {
        System.out.println("父类的无参构造器被调用");
    }

    

    public Student(String name) {
        System.out.println("父类有参构造器被调用");
    }



    public void setScore(double score) {
        this.score = score;
    }

    public void showInfo() {
        System.out.println("学生名 " + name + " 年龄 " + age + " 成绩 " + score);
        
    }

    // 通过公共方法访问私有属性
    public double getScore() {
        System.out.println("父类方法getScore被执行");
        return score;
    }
}




