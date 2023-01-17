package Chapter7.innerClass_;

import Chapter7.innerClass_.Outer03.Inner03; // 可以通过导入包加入引用

public class MemberInnerClass {
    public static void main(String[] args) {
        // 外部类使用内部类
        Outer03 outerClass = new Outer03();
        outerClass.m2();
        System.out.println("===================");

        // 方式一: 外部其他类访问内部类. 需要创建一个外部类实例
        Inner03 innerClass = outerClass.new Inner03();
        innerClass.m1();
        System.out.println("==============");

        // 方式二: 通过外部类公开的返回Inner03的方法来获得成员内部类对象
        Outer03.Inner03 innerClass02 = outerClass.getInner03();
        innerClass02.n1 = 500;
        innerClass02.m1();
    }
    
}

class Outer03 {
    private int n1 = 100;
    String name = "外部类03";

    public class Inner03 {
        int n1 = 200;

        public void m1() {
            System.out.println("成员内部类m1方法被调用");
            System.out.println("就近原则成员内部类的n1: " + n1);
            System.out.println("通过Outer03.this.n1访问外部类私有属性n1: " + Outer03.this.n1);
        }
    }

    public Inner03 getInner03() {
        return new Inner03();
    }

    public void m2() {
        Inner03 inner03 = new Inner03(); // 外部类体中任何位置都可以创建成员内部类对象
        System.out.println("成功创建成员内部类对象: " + inner03);
    }

}
