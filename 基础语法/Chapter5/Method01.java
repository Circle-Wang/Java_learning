package Chapter5;

public class Method01 {
    public static void main(String[] args) {

        // 需要先创建对象, 再调用方法
        Person p1 = new Person();
        p1.speak();     // 执行方法
        p1.cal01(10); // 传入参数执行方法

        int res = p1.getSum(12, 10); // 附带返回值的方法
        System.out.println("getSum方法返回值为: " + res);

    }
    
}

class Person {
    // 属性
    int age;
    String name;

    // public: 表示这个方法是公开的
    // void: 表示这个方法没有返回值
    public void speak() {
        System.out.println("我是一个好人");
    }

    // 可以接收形参，()表示形参列表，可以接收用户输入
    public void cal01(int n) {
        int res = 0;
        for (int i = 0; i <= n; i++) {
            res += i;
        }
        System.out.println("cal01的计算结果是: " + res);
    }


    // 附带返回值的方法, 调用该方法会返回一个int类型的值
    public int getSum(int n1, int n2) {
        speak(); // 调用同一个类的方法
        return n1+n2;
    }
}
