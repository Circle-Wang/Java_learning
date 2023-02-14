package Chapter3;


// 利用信号灯法解决生产者消费者模型-->标志法
public class ThreadCollaboration2 {
    public static void main(String[] args) {
        TV tv = new TV();

        new Player(tv).start();
        new Watcher(tv).start();

    }
}

// 生产者 ——> 演员
class Player extends Thread{
    TV tv;
    public Player(TV tv){
        this.tv = tv;
    }
   
    // 生产
    @Override
    public void run() {
        for (int index = 0; index < 20; index++) {
            if (index%2 == 0){
                this.tv.play("快乐大本营");
            } else {
                this.tv.play("抖音记录美好生活");
            }
            
        }
        
    }
}

// 消费者 ——> 观众
class Watcher extends Thread{
    TV tv;
    public Watcher(TV tv){
        this.tv = tv;
    }

    // 消费
    @Override
    public void run() {
        for (int index = 0; index < 20; index++) {
            this.tv.watch();
        }
    }
}

// 产品 ——> 节目
class TV{
    // 演员表演时, 观众等待 flag = T
    // 观众观看时, 演员等待 flag = F

    String voice; // 当前表演的节目
    boolean flag = true; 

    // 由生产者执行
    public synchronized void play(String voice){
        // 如果flag = F 则演员需要等待观众看完才能去表演。
        while (flag == false){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("演员表演了: " + voice);
        this.voice = voice;
        
        // 通知观众观看(释放被wait()的线程)
        this.flag = false;
        this.notifyAll();

    }

    // 由消费者执行
    public synchronized void watch(){
        // 如果 flag = T 观众需要等待演员表演完成
        while (flag == true){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("观看了: " + voice);

        // 通知演员表演
        this.flag = true;
        this.notifyAll();
        

    }

    
}


