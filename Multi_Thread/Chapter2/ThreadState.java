package Chapter2;

// 观察测试线程的状态
public class ThreadState {

    public static void main(String[] args) throws InterruptedException {
        Thread myThread = new Thread(()->{
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName()+ "已经结束");
        });  // 采用lambda表达式创建一个线程

        // 返回该线程的状态myThread.getState()
        Thread.State myState = myThread.getState();
        System.out.println("线程启动前状态:" + myState); // 此时状态应该是NEW

        // 观察启动后的状态
        myThread.start();
        myState = myThread.getState();
        System.out.println("线程start()后状态:" + myState); // 此时状态应该是RUN

        // 每500ms打印一次线程状态
        while (myState != Thread.State.TERMINATED) {
            Thread.sleep(500);      
            myState = myThread.getState(); // 更新线程状态
            System.out.println(myState);   // 此时状态应该是TIMED_WAITING
        }
        
    }


    
    
}
