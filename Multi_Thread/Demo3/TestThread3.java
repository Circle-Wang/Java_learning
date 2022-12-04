package Demo3;


// 创建线程方式2：实现runnable接口，重写run方法。
// 执行线程需要创建Thread对象，并丢入runnable接口对象
public class TestThread3 implements Runnable{

    @Override
    public void run() {
        for(int i = 0 ; i < 20 ; i++){
            System.out.println("我在看代码");
        }

    }

    public static void main(String[] args) {
        // 主线程

        // 创建一个接口对象
        TestThread3 testThread3 = new TestThread3();

        // 创建Thread对象，通过Thread对象来开启线程, 注意要丢入接口类
        Thread thread1 = new Thread(testThread3);


        // 调用start()方法开启线程并行
        thread1.start();
        new Thread(testThread3).start();   // 这开启了另一个线程，但是作用的是同一个类

        for (int i = 0; i < 20; i++) {
            System.out.println("我在学习"+i);
        }

    }


    
}
