package DesignPattern;


// 静态代理模式讲解
public class StaticProxy {
    public static void main(String[] args) {

        // 一个被代理对象，本来可以直接调用couple.HappyMarry()完成婚礼
        // 为了更专业，可以交给代理类去完成婚礼中需要的其他部门。
        Couple couple = new Couple();  

        // 代理类 
        WeddingCompany weddingCompany = new WeddingCompany(couple);
        weddingCompany.HappyMarry();  // 调用代理类的.HappyMarry()方法，其中除了执行couple.HappyMarry()外，还会执行其他操作
    }
    
}


// 结婚类
interface Marry{
    void HappyMarry();
}


// 夫妻类 继承 自结婚类
class Couple implements Marry{
    @Override
    public void HappyMarry() {
        System.out.println("我们结婚了, 真开心");
        
    }
}


// 婚庆公司 "帮助" 夫妻对象 完成结婚这个操作的全部过程
class WeddingCompany implements Marry {
    private Marry target;  // 帮助结婚的对象

    // 在构造函数中要求传入一个被代理的对象
    public WeddingCompany(Marry target) {
        this.target = target;
    }

    // 实现了Marry接口中的HappyMarry()方法
    @Override
    public void HappyMarry() {
        before();
        this.target.HappyMarry(); // 动态绑定会执行target的HappyMarry方法
        after();

    }

    // 下面是属于婚庆公司类的专有方法，帮助夫妻类实现婚礼
    private void after() {
        System.out.println("结婚之后，收尾款");
    }

    private void before() {
        System.out.println("结婚之前，布置现场");
    }

}