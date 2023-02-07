package Chapter6.Object_;

@SuppressWarnings({"unused"}) // 忽略不使用的警告
public class FinalizeTest {
    public static void main(String[] args) {
        Car car = new Car("宝马");
        car = null;  // 此时引用置空, Car对象被视为垃圾。
        System.gc(); // 主动调用垃圾回收器。异步
    }    
}

class Car {
    private String name;

    public Car(String name) {
        this.name = name;
    }

    protected void finalize() throws Throwable {
        System.out.println("Car的finalize方法被call");
        System.out.println(name + "被回收");
    }

    
}