package Demo13;
/*
 * Person类，Teacher类
 * 多态：父类的引用可以指向子类对象。
 * 注意：
 *      - 如果子类重写了父类的方法，此时父类可以调用子类重写后的方法
 *      - 但此时不能调用父类中不存在的方法
 *      - 如果非要使用子类单独的方法，则需要使用强制类型转化，类似于基础类型转化高转低： (转化为的子类) 对象
 * 
 * instanceof关键字: 左边是对象a，右边是B类；当对象a是右边B类或B的子类所创建对象时，返回true；否则，返回false。
 * 注意：a instanceof B会出现无法编译的问题，如果出现该问题说明声明a时的数据类型与B这个类没有关系。
*/

public class Demo13 {
    public static void main(String[] args) {
        // 一个对象的实际类型是确定的
        // new Person();
        // new Teacher();

        // 引用类型就不去确定了父类的引用可以指向子类对象
        Person s1 = new Teacher();
        Object s2 = new Teacher();
        System.out.println("=========");
        
        // 此时s1能调用的方法只有是父类Person存在的 或者 被子类重写的方法
        s1.shout();  // 由于子类重写了父类方法所以执行的子类的函数
        // s2.shout(); // 由于Object类中没有shout方法因此报错了
    }
}
