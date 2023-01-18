package Chapter7;

@SuppressWarnings({"unused"}) // 忽略不使用的警告
public class CodeBlockTest01 {
    private String name;
    private double price;
    private String director;
    private static int sum;

    public static void main(String[] args) {

        System.out.println(CodeBlockTest01.sum); // 使用类静态成员时，类加载。普通代码块不会执行
        
        new CodeBlockTest01("你好李焕英");  // 当创建对象时，也是类加载时。
        new CodeBlockTest01("这个杀手不太冷", 125);
        
    }
    
    // 静态代码块(当类被加载时调用，且只会调用一次，也就是只有当类第一次被加载时调用)
    static {
        System.out.println("----静态代码块被调用---");
    }


    // 普通代码块
    // 当我们每创建一个对象时，无论调用那个构造器，都会先调用这个普通代码块
    {
        System.out.println("----普通代码块被调用---");
        System.out.println("电影打开");
        System.out.println("广告开始");
    }

    // 构造器
    public CodeBlockTest01(String name) {
        this.name = name;
        System.out.println("1参数构造器被调用");
    }

    public CodeBlockTest01(String name, double price) {
        this.name = name;
        this.price = price;
        System.out.println("2参数构造器被调用");
    }

    public CodeBlockTest01(String name, double price, String director) {
        this.name = name;
        this.price = price;
        this.director = director;
        System.out.println("3参数构造器被调用");
    }

    
    


    
}
