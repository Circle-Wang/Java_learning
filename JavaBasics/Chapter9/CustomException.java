package Chapter9;

// 自定义异常
public class CustomException {
    public static void main(String[] args) {
        int age = 180;
        if (!(age >= 18 && age <= 120)) {
            // 如果不满足则抛出异常
            throw new AgeException("你输入的年龄有误");
        }

        System.out.println("年龄为: " + age);
    }
    
}


// 这是自定义的一个异常
class AgeException extends RuntimeException {

    public AgeException(String message) { // 构造器，此处的message会在触发异常时显示在控制台中
        super(message);   
    }
    
}
