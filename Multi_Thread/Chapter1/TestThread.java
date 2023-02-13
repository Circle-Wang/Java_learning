package Chapter1;


// 总结：线程开始不一定立即执行，由CPU调用执行
public class TestThread {

    // 这是主线程
    public static void main(String[] args) throws InterruptedException {
        // 创建一个线程对象
        Cat cat = new Cat();
        // 调用start()方法开启线程并行，
        // 此时调用cat.run()方法，此时run()方法与主程序一起并行执行, 主线程不会阻塞
        cat.start();

        // 创建Dog对象(并不是线程对象，因为其并为继承自Thread)
        Dog dog = new Dog();
        // 需要将dog传递给Thread对象，使用Thread类的构造器传入
        Thread dogThread = new Thread(dog);
        dogThread.start();

        for (int i = 0; i < 20; i++) {
            Thread.sleep(700);
            System.out.println("主线程执行中" + Thread.currentThread().getName());
        }

    }

    
}

// 创建线程方式1: 继承Thread类, 重写run()方法, 调用start开启线程
class Cat extends Thread {
    @Override
    public void run() {
        // 业务逻辑
        for(int i = 0 ; i < 20 ; i++){
            try {
                Thread.sleep(1000);  // 休眠1000ms
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("我是小猫咪" + "线程名:" + Thread.currentThread().getName());
        }
        
    }
}

// 创建线程方式2: 实现runnable接口，重写run方法。无法直接使用 对象.start()启动线程
class Dog implements Runnable {
    @Override
    public void run() {
        // 业务逻辑
        for(int i = 0 ; i < 20 ; i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("我是小狗" + "线程名:" + Thread.currentThread().getName());
        }
    }
}
