package Demo1;
/*
 * 变量定义:
 * type varName [=value];
 * 数据类型 变量名 [=值];
 * 
 * 常量定义: 
 * final 数据类型 常量名 = 值
 * 常量名常使用大写, 只需要使用一个装饰词final
 * 
 * 类变量定义:
 * static 数据类型 变量名 = 值
 * 使用装饰词static即可，能在类方法中直接被使用
 * 
*/ 

public class VariableTest {
    // 实例变量(从属于对象), 使用“实例.变量名”来调用
    // 如果定义是不给初始值, 会采用默认值(bool默认False)
    String name;
    int age;

    // 类变量(从属于类)
    static double salary = 20500;

    public static void main(String[] args) {
        // 普通变量(局部变量)
        int b = 13;
        char c = 's';
    }
}
