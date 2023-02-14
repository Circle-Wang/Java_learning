package Chapter3;

public class ConcurrencySolution {

    public static void main(String[] args) {

        SafeSellTicket sellTicket = new SafeSellTicket();

        // 启动三个售票员同时售票, 对同一个资源进行操作
        new Thread(sellTicket, "小明").start(); // 创建Thread对象同时传入接口对象，并给该线程命名
        new Thread(sellTicket, "李华").start();
        new Thread(sellTicket, "张三").start();

    }
}


// 一个售票亭类,包含有20张票
class SafeSellTicket implements Runnable {
    private int ticketNum = 20;
    private boolean loop = true;


    // 该方法为同步方法, 同一时间至多一个线程能调用该对象的该方法(锁加载对象上的)
    public synchronized void sell() {
        if (ticketNum <= 0) {
            System.out.println("售票结束");
            loop = false;
            return; 
        }
        System.out.println("售票员 " + Thread.currentThread().getName() + " 售出一张票 " +
                "目前剩余票数: " + --ticketNum);
    }

    @Override
    public void run() {
        while (loop) {
            try {
                sell();
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

