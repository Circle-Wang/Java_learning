package Demo8;

// 测试线程的优先级
public class TestPriority {
    public static void main(String[] args) {
        // 显示主线程的优先级（默认优先级为5）
        System.out.println(Thread.currentThread().getName() + "-->" + Thread.currentThread().getPriority());

        MyPriority myPriority = new MyPriority();
        
        Thread t1 = new Thread(myPriority);
        Thread t2 = new Thread(myPriority);
        Thread t3 = new Thread(myPriority);
        Thread t4 = new Thread(myPriority);
        Thread t5 = new Thread(myPriority);

        // 先设置线程的优先级再启动，启动后无法改变线程优先级
        t2.setPriority(1);
        t3.setPriority(4);
        t4.setPriority(6);
        t5.setPriority(Thread.MAX_PRIORITY); // 最大优先级为10
        
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }

    
}

class MyPriority implements Runnable{

    @Override
    public void run() {
        // 打印线程优先级
        System.out.println(Thread.currentThread().getName() + "-->" + Thread.currentThread().getPriority());
        
    }

}
