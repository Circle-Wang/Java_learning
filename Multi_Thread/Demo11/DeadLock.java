package Demo11;


// 死锁: 多个线程互相持有对方需要的资源，形成僵持
public class DeadLock {
    public static void main(String[] args) {
        Makeup girl1 = new Makeup(0, "小红");
        Makeup girl2 = new Makeup(1, "小兰");

        girl1.start();
        girl2.start();
    }
    
}


// 口红
class Lipstick{

}

// 镜子
class Mirror{

}

// 化妆
class Makeup extends Thread{
    // 我们需要的资源只有一份，所以可以使用static来保证
    static Lipstick lipstick = new Lipstick();
    static Mirror mirror = new Mirror();
    int choice;      // 选择
    String girlName; // 使用化妆品的人

    public Makeup(int choice, String girlName){
        this.choice = choice;
        this.girlName = girlName;

    }


    @Override
    public void run() {
        try {
            makeup();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    // 化妆，相互持有对方的锁
    private void makeup() throws InterruptedException {

        // 不同的人有不同的选择，则会执行不同的动作，选择1
        // 由于同步块没有执行完毕，所以不会释放口红的锁，而要释放口红锁，就必须获得镜子的锁
        if (choice==0){
            synchronized(lipstick){ // 获得口红的锁
                System.out.println(this.girlName + "获得口红的锁");
                Thread.sleep(1000);

                synchronized(mirror){ // 1s后想获得镜子的锁
                    System.out.println(this.girlName + "获得镜子的锁");
                }
            }
        } 

        // 选择2
        if (choice==1){
            synchronized(mirror){ // 获得镜子的锁
                System.out.println(this.girlName + "获得镜子的锁");
                Thread.sleep(2000);

                synchronized(lipstick){ // 2s后想获得口红的锁
                    System.out.println(this.girlName + "获得口红的锁");
                }
            }
        }

        
    }

}
