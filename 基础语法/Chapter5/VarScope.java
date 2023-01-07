package Chapter5;

public class VarScope {

    public static void main(String[] args) {
        new Dog().say();
        
    }
    
}


class Dog{

    double weight;  // 属性可以不用初始化即可使用, 因为有默认值
    String name = "小花";

    // public void hi() {
    //     int num;   // 局部变量没有默认值
    //     System.out.println(num);  // 因此没有默认值
        
    // }


    public void say() {

        String name = "小黑_局部"; // 和属性重名
        System.out.println(name); // 会就近使用局部变量的name
        
    }


}
