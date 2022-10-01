package Demo6;

public class StaticProxy {
    public static void main(String[] args) {

        You Circle = new You();  // 一个真实对象，本来可以直接调用Circle.HappyMarry(), 但是可以交给代理对象去执行，代理对象还可以执行一些其他工作。

        WeddingCompany weddingCompany = new WeddingCompany(Circle);
        weddingCompany.HappyMarry();  // 由weddingCompany对象调用HappyMarry()方法，该方法中包含有You这个类的HappyMarry方法


        // 多线程表示
        // Thread()就可以看成一个代理对象类它实现了Runnable接口，
        // 本来我们需要重写run方法，由于Runnable接口中只有一个抽象类，因此可以使用lambda表达式来创建一个重写run方法的类
        Thread myThread = new Thread(()->{
            System.out.println("线程1");
        });
        myThread.start(); // 启动线程
        

    }
    
}


// 创建一个接口
interface Marry{
    void HappyMarry();
}


// 真实角色, 你去结婚
class You implements Marry{

    @Override
    public void HappyMarry() {
        System.out.println("我结婚了, 真开心");
        
    }
}

// 代理角色，婚庆公司，帮助你结婚
class WeddingCompany implements Marry{

    private Marry target;  // 帮助结婚的对象

    public WeddingCompany(Marry target){
        this.target = target;
    }

    @Override
    public void HappyMarry() {
        before();
        this.target.HappyMarry();
        after();
        
    }

    private void after() {
        System.out.println("结婚之后，收尾款");
    }

    private void before() {
        System.out.println("结婚之前，布置现场");
    }

}