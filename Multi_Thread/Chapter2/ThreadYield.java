package Chapter2;


// 测试礼让线程，礼让不一定成功
public class ThreadYield {

    public static void main(String[] args) {
        MyYield myYield = new MyYield();

        new Thread(myYield, "小明").start();
        new Thread(myYield, "小红").start();
    }
    
}


class MyYield implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+ ":线程开始执行");
        Thread.yield(); // 线程礼让
        System.out.println(Thread.currentThread().getName()+ ":线程停止执行");
        
    }

}
