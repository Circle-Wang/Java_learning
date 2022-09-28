/*
 * 抽象类/抽象方法：abstract关键字
 * 抽象类：
 *  - 不能通过new 来创建对象，抽象类只能用来被继承
 *  - 具有抽象方法的类，必须是一个抽象类，但抽象类里可以有普通方法。
 * 
*/

public abstract class Demo14 {

    public static void main(String[] args) {
        
    }

    // abstract修饰的方法称为抽象方法，没有方法体
    // 如果继承该类的子类必须要实现这个抽象方法
    public abstract void doSomething();

}
