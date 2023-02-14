package Chapter2;

// 测试停止线程
// 1.建议线程正常停止
// 2.设置一个标志位

public class ThreadStop {

    public static void main(String[] args) throws InterruptedException {

        MyThread tStop = new MyThread();
        new Thread(tStop).start(); // 开始执行

        // 注意此时线程和主线程在同时执行, 当主线程执行到tStop.stop()时候，会改变线程循环标志符，从而停止了线程
        for (int i = 0 ; i < 20 ; i++){
            Thread.sleep(500);
            System.out.println("main线程证在执行" + i);
            if (i == 10){
                tStop.stop();
                System.out.println("线程该停止了");
            }
        }
    }
   
    
}

class MyThread implements Runnable{
    private int count = 0;
    private boolean loop = true;

    @Override
    public void run() {
        while (loop) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("正在第"+ (++count) + "次运行" + Thread.currentThread().getName() + "线程");
        }
 
    }

    // 定义一个方法, 用于改变标志符, 从而停止线程
    public void stop() {
        this.loop = false;
    }

}

   
