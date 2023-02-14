package Chapter3;

// 利用缓冲区解决生产者消费者模型-->管程法
public class ThreadCollaboration1 {
    public static void main(String[] args) {
        SynContainer container = new SynContainer();

        new Product(container).start();
        new Consumer(container).start();

    }
    
}

// 生产者
class Product extends Thread {
    SynContainer container;

    public Product(SynContainer container) {
        this.container = container;
    }

    // 生产
    @Override
    public void run() {
        for (int index = 0; index < 20; index++) {
            System.out.println("生产了id为" + index + "的鸡");
            container.push(new Chicken(index));
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

// 消费者
class Consumer extends Thread{
    SynContainer container;

    public Consumer(SynContainer container){
        this.container = container;
    }

    // 消费
    @Override
    public void run() {
        for (int index = 0; index < 100; index++) {
            System.out.println("消费了-->id:" + container.pop().id + "鸡"); 
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }   
        }
    }

}

// 产品类
class Chicken{
    int id;

    public Chicken(int id) {
        this.id = id;
    }
}

// 缓冲区容器
class SynContainer{

    Chicken[] chickens = new Chicken[10];   // 产品列表，最多存放10个产品
    int count = 0;

    // push方式用于生产者调用, 对整个对象施加了锁
    public synchronized void push(Chicken chicken){
        while (count == chickens.length){   // 如果容器满了，生产者需要等待
            try {
                this.wait();    // 该语句放在循环中是因为防止被this.notifyAll()重新调用
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // 如果能走出循环说明有足够位置放入产品
        chickens[count] = chicken;
        count++;

        // 唤醒被wait()的所有进程
        this.notifyAll();

    }



    // 消费者消费产品
    public synchronized Chicken pop(){
    
        while (count == 0){  // 如果容器中没有产品, 消费者需要等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // 消费者消费数据
        count--;  // 注意要先count--，再提取数据
        Chicken chicken = chickens[count];

        // 唤醒被wait()的所有进程
        this.notifyAll();
        
        return chicken;

    }

}