package Chapter2;

// 测试线程插队
public class ThreadJoin implements Runnable{
    public static void main(String[] args) throws InterruptedException {

        ThreadJoin testJoin = new ThreadJoin();
        Thread myThread = new Thread(testJoin);
        myThread.start(); // 启动子线程

        // 此时main线程和子线程同时在执行
        for (int i = 0; i < 100; i++) {
            Thread.sleep(300);
            System.out.println("main线程正在执行" + i);
            if (i == 20){
                System.out.println("main线程被插队, 开始被阻塞");
                myThread.join(); // main线程被插队, main线程会被阻塞, 会等待MyThread执行完之后才能执行main线程
                System.out.println("main线程阻塞完毕,开始执行后续剩余内容");
            }
        }
        
    }

    @Override
    public void run() {
        for (int i = 0; i <= 50; i++) {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("子线程正在执行" + i);
        }
    }
    
}
