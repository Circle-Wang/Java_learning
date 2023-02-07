package Chapter6.modifier_;

public class B {


    public void say() {

        A a = new A();  // 在同一包下可以不用import

        //在同一个包下可以访问 n1,n2,n3 不能访问n4
        System.out.println("n1=" + a.n1 + " n2=" + a.n2 + " n3=" + a.n3); // a.n4会报错
        
    }
    
}
