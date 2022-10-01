package Demo7;

// 测试线程插队
public class TestJoin implements Runnable{

    public static void main(String[] args) throws InterruptedException {

        // 启动我们的线程
        TestJoin testJoin = new TestJoin();
        Thread myThread = new Thread(testJoin);
        myThread.start();  

        // 主线程
        // 此时主线程和上个线程同时在执行
        for (int i = 0; i < 100; i++) {
            System.out.println("main->" + i);
            if (i==20){
                myThread.join(); // 主线程被插队，main线程会被阻塞，会等待MyThread执行完之后才能执行主线程
            }
        }
        
    }

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            System.out.println("线程vip来了->" + i);
        }
    }
    
}
