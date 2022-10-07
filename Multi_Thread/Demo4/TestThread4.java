package Demo4;


public class TestThread4 implements Runnable{

    private int ticketNums = 10;

    @Override
    public void run() {
        while (true) {
            if (ticketNums <= 0) {
                break;
            }
            try {
                Thread.sleep(200);  // 模拟延迟, 200毫秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Thread.currentThread().getName()可以获得当前线程的名字
            System.out.println(Thread.currentThread().getName() + "——>拿到了第"+ ticketNums-- + "票");
        }
    }

    public static void main(String[] args) {
        // 主线程

        // 创建一个接口对象，
        TestThread4 testThread4 = new TestThread4();

        new Thread(testThread4,"小明").start();   // 创建Thread对象同时传入接口对象，并给该线程命名
        new Thread(testThread4,"李华").start();
        new Thread(testThread4,"张三").start();

    }


    
}
