package Chapter2;

// 测试守护线程
public class ThreadDaemon {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Talker(), "马蓉和宋喆");
        // Thread thread2 = new Thread(new Talker(), "其他工作人员");
        
        thread1.setDaemon(true);  // 设置该线程为守护线程，默认为false
        thread1.start();             // 守护线程启动(先设置为守护线程再启动)
        // thread2.start();

        for (int i = 0; i < 5; i++) {
            Thread.sleep(500);
            System.out.println("宝强在辛苦工作");
        }
        System.out.println("宝强工作结束");  // 若不将thread设置为手动线程，则main线程执行完该行时，thread仍在继续执行
    }
}




class Talker implements Runnable{

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "在聊天~~~~");
        }
        
        
    }

}