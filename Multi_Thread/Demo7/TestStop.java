package Demo7;

// 测试停止线程
// 1.建议线程正常停止
// 2.设置一个标志位

public class TestStop implements Runnable {

    private boolean flag = true;

    public static void main(String[] args) {
        TestStop tStop = new TestStop();

        new Thread(tStop).start();

        // 注意此时线程和主线程在同时执行, 当主线程执行到tStop.stop()时候，会改变线程循环标志符，从而停止了线程
        for (int i = 0 ; i < 20 ; i++){
            System.out.println("main-"+i);
            if (i == 10){
                tStop.stop();
                System.out.println("线程该停止了");
            }
        }
    }


    @Override
    public void run() {
        int i = 0;
        while (flag) {
            System.out.println("正在第"+ i++ + "次运行" + Thread.currentThread().getName() + "线程");
        }
    }

    // 定义一个方法改变标志符，从而停止线程
    public void stop(){
        this.flag = false;
    }
    
}
