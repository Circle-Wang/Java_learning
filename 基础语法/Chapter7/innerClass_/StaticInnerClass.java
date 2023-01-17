package Chapter7.innerClass_;


public class StaticInnerClass {
    public static void main(String[] args) {
        Outer04 outer04 = new Outer04();
        outer04.m1();
        System.out.println("==================");
        // 方式一: 外部类访问内部类(相比成员内部类不再需要实例化)
        Outer04.Inner04 innerClass = new Outer04.Inner04();
        System.out.println(innerClass);

        // 方式二: 公开一个静态方法返回静态内部类
        Outer04.Inner04 innerClass02 = Outer04.getInner04();
        System.out.println(innerClass02);
        
    }
    
}


class Outer04 {
    private static int num = 100;
    private static int n1 = 200;
    String name = "外部类04";

    // 静态内部类成员
    public static class Inner04 {

        private static int n1 = 300;
        public void say() {
            System.out.println("静态内部类被调用");
            System.out.println("访问外部类静态属性n1: " + num);
            // System.out.println(name); // 无法访问非静态成员
            System.out.println("就近原则访问与外部类重名的静态属性: " + n1);
            System.out.println("采用Outer04.n1访问外部类重名的静态属性: " + Outer04.n1);
        }
    }

    public static Inner04 getInner04() {
        return new Inner04();
    }

    public void m1() {
        Inner04 inner04 = new Inner04(); // 外部类体中任何位置都可以创建成员内部类对象
        inner04.say();
        System.out.println("成功创建成员内部类对象: " + inner04);
    }

}
