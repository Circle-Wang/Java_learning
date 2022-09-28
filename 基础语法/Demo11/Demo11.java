package Demo11;
/*
 * Teacher类, Person类
 * super注意点: 
 *      1、super()调用父类的构造方法，必须在子类构造方法的第一个(一般会默认执行所以我们不用写)
 *      2、super.属性/方法 只能出现在子类的方法中
 *      3、super()是父类的构造方法; this()是子类的构造方法。
 * 在主程序中调用方法的顺序是：先查找当前类时候有该方法，如果没有则查找父类是否有该方法.
 * 
 *
*/

public class Demo11 {

    public static void main(String[] args) {
        Teacher wang = new Teacher();
        wang.shout(); // 执行子类方法(会优先查找子类中是否有该方法,如果有则调用否则查找父类方法)        
    }
    
}
