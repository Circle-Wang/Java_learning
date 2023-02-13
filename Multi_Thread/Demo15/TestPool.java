package Demo15;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// 测试线程池
public class TestPool {
    public static void main(String[] args) {
        // 1. 创建服务，创建线程池子(10个线程大小的池子)
        ExecutorService service = Executors.newFixedThreadPool(10);

        service.execute(new MyThread());  // 类似于thread(new MyThread()).start();
        service.execute(new MyThread());
        service.execute(new MyThread());
        service.execute(new MyThread());

        // 2.关闭连接
        service.shutdown();

    }
    
}


class MyThread implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 3 ; i++) {
            System.out.println(Thread.currentThread().getName());
        }
        
    }

} 