package Demo12;

import java.util.concurrent.locks.ReentrantLock;

public class TestLock {
    public static void main(String[] args) {
        GetTicket getTicket = new GetTicket();

        new Thread(getTicket, "小明").start();
        new Thread(getTicket, "小红").start();
        new Thread(getTicket, "小兰").start();
        
    }
 
}


class GetTicket implements Runnable{
    int ticketNums = 10;

    // 定义lock锁
    private final ReentrantLock lock = new ReentrantLock();

    
    @Override
    public void run() {
        while (true){
            try {
                lock.lock();   // 加锁
                if (ticketNums > 0){
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + "获得了第" + ticketNums-- + "票");
                } else{
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                // 解锁
                lock.unlock();
            }
        }
        
    }
}




