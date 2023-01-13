package Chapter7.static_;

public class Student {

    private String name;
    public static double fee = 0;

    public Student(String name) {
        this.name = name;
    }

    // 累积学生学费,静态方法
    public static void payFee(double fee) {
        Student.fee += fee;
        
    }


    
}
