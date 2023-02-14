package Chapter3;


public class ConcurrencyProblem{
    public static void main(String[] args) {

        SellTicket sellTicket = new SellTicket();
        
        // 启动三个售票员同时售票, 对同一个资源进行操作
        new Thread(sellTicket,"小明").start();   // 创建Thread对象同时传入接口对象，并给该线程命名
        new Thread(sellTicket,"李华").start();
        new Thread(sellTicket,"张三").start();

    }

    
}

// 一个售票亭类,包含有20张票
class SellTicket implements Runnable {
    private int ticketNum = 20;

    @Override
    public void run() {
        while (true) {
            if (ticketNum <= 0) {
                System.out.println("售票结束");
                break;
            }

            try {
                Thread.sleep(500);
                System.out.println("售票员 " + Thread.currentThread().getName() + " 售出一张票 " +
                        "目前剩余票数: " + --ticketNum);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}


