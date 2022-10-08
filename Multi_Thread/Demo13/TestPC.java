package Demo13;

// 利用缓冲区解决生产者消费者模型-->管城法
public class TestPC {
    public static void main(String[] args) {
        SynContainer container = new SynContainer();

        new Product(container).start();
        new Consumer(container).start();

    }
    
}

// 生产者
class Product extends Thread{
    SynContainer container;

    public Product(SynContainer container){
        this.container = container;

    }

    // 生产
    @Override
    public void run() {
        for (int index = 0; index < 100; index++) {
            System.out.println("生产了第"+index+"只鸡");
            container.push(new Chicken(index));
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
            System.out.println("消费第-->"+container.pop().id+"只鸡");    
        }
    }

}

// 产品
class Chicken{
    int id;

    public Chicken(int id) {
        this.id = id;
    }
}

// 缓冲区
class SynContainer{

    // 产品列表，10个产品
    Chicken[] chickens = new Chicken[10];
    int count = 0;

    // 生产者放入产品
    public synchronized void push(Chicken chicken){
        // 如果容器满了，生产者需要等待
        while (count == chickens.length){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // 生产者丢入产品进入到容器中
        chickens[count] = chicken;
        count++;

        // 通知消费者消费
        this.notifyAll();

    }



    // 消费者消费产品
    public synchronized Chicken pop(){
        // 如果容器无了，消费者需要等待
        while (count == 0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // 消费者消费数据
        count--;  // 注意要先count--，再提取数据
        Chicken chicken = chickens[count];

        // 通知生产者可以生产了
        this.notifyAll();
        
        return chicken;

    }












}