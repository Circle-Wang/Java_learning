package Chapter2;

public class ThreadMethod {
    public static void main(String[] args) throws InterruptedException {
        TestThread testThread = new TestThread();

        Thread myThread = new Thread(testThread);
        myThread.setName("小华线程");
        myThread.setPriority(7); // 设置优先级
        
        myThread.start(); // 执行线程
        

        for (int i = 0; i < 5; i++) {
            Thread.sleep(1000); // 每间隔1s打印一句
            System.out.println("距离中断还有" + (4-i) + "s");
            
        }
        myThread.interrupt(); // 向正在执行(也可能是休眠)的线程中抛出InterruptedException异常。
    }
    
}

class TestThread implements Runnable{

    @Override
    public void run() {
        while (true) {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "正在执行~~" + i);
            }

            try {
                System.out.println("开始休眠");
                Thread.sleep(20000); // 每执行一次for休眠20s
            } catch (InterruptedException e) {
                // 当InterruptedException被捕获时就会触发catch
                System.out.println(Thread.currentThread().getName() + "被 interrupt了");
            }
        }

        
    }

}
