package Demo7;


// sleep方法是阻塞当前线程，因此也可以阻塞主线程

public class TestSleep{

    // 倒计时方法
    public static void tenDown() throws InterruptedException{
        int num = 10;

        while (true) {
            Thread.sleep(1000); // 睡眠1s
            System.out.println( "线程"+ Thread.currentThread().getName() + "倒计时" + num--);
            if (num<=0){
                break;
            }
        }
    }


    public static void main(String[] args) {

        try {
            tenDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    
}
