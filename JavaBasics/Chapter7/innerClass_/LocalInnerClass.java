package Chapter7.innerClass_;


public class LocalInnerClass {
    public static void main(String[] args) {
        Outer01 outer01 = new Outer01();
        outer01.m2();
    }
    
}

class Outer01 { // 外部类
    private int n1 = 100;
    String name = "外部类01";


    private void m1() {
        System.out.println("外部类的私有方法m1被调用");
    }

    public void m2() {
        
        // 局部变量只能用final修饰，其他访问修饰符不能修饰
        // 局部内部类, 地位与静态变量一样, 因此也只能可以用final修饰
        final class Inner01 {
            // 局部内部类也可以定义属性，拥有类的所有成员
            private int n1 = 800;

            public void innerM1() {  // 局部内部类
                System.out.println("=======局部内部类Inner01的innerM1方法开始被调用==========");
                System.out.println("Outer01的name是" + name); // 可以直接使用外部类的属性
                m1();  // 直接使用外部类的私有方法
                System.out.println("如果局部内部类属性重名则会根据就近原则: " + n1); // 800
                System.out.println("使用Outer01.this.n1的方式访问重名的外部类属性: " +
                        Outer01.this.n1);  // Outer01.this返回的地址是调用m2方法的Outer对象地址
            }
        }

        // 作用域限于: 定义局部内部类的代码块内部使用
        // 在作用域中使用局部内部类需要实例化
        Inner01 inner01 = new Inner01();
        inner01.innerM1();

    }

}
