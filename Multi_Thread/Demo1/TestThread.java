package Demo1;

// 继承Thread类, 重写run()方法, 调用start开启线程
// 总结：线程开始不一定立即执行，由CPU调用执行
public class TestThread extends Thread {

    @Override
    public void run() {
        // run 方法体
        for(int i = 0 ; i < 20 ; i++){
            System.out.println("我在看代码");
        }
    }

    public static void main(String[] args) {
        // 主线程

        // 创建一个线程对象
        TestThread testThread1 = new TestThread();
        // 调用start()方法开启线程并行，此时程序会去调用run()方法，此时run()方法与主程序一起并行执行。
        testThread1.start();

        for (int i = 0; i < 20; i++) {
            System.out.println("我在学习"+i);
        }

    }

    
}
