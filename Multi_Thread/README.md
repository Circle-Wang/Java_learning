# 多线程知识

## 1.进程(Process)与线程(Thread)
- 进程是程序的一次执行过程, 是一个动态概念, 是系统资源分配的单位
- 在一个进程中可以包含有多个线程, 一个进程至少有一个线程, 线程是CPU调度和执行的单位
- 注意: 很多线程是模拟出来的, 真正的多线程是指多个CPU, 即多核, 如服务器。如果模拟出来的多线程, 即再一个CPU下, 在同一时间点CPU只能执行一个代码, 因为切换很快, 所以就有同时执行的错觉。

### 1.1 线程
- 线程是独立执行的路径。
- main()称之为主线程, 为系统的入口, 用于执行整个程序。
- 在一个进程中如果开辟了多个线程, 线程的运行由调度器安排调度, 调度器与操作系统密切相关, 线程的先后顺序不能人为干预。
- 对同一份资源操作时, 会存在资源抢夺的问题, 此时需要加入并发控制(排队)。
- 线程会带来额外开销, 如CPU调度时间, 并发控制开销。
- 每个线程在自己的工作内存交互, 内存控制不当会造成数据不一致。

### 1.2 进程的创建
- 方法一: 继承Thread类(Demo1)
    - 多线程网图下载(Demo2)
    - 执行多线程需要创建多个对象
- 方法二: 实现Runnable接口(Demo3)
    - 可以对同一个runnable接口对象执行多个线程
    - 推荐使用: 避免了单继承的局限性, 灵活方便, 同一个对象可以被多个线程使用。

### 1.3 并发问题
- 对于同一个对象来说, 内部属性是唯一的, 如果多个线程对同一个对象进行操作内部属性则可能会出现线程不安全。
- Demo4: 三个人抢票, 当剩余票数等于0时, 则不再抢票了。
    - 当三个线程同时进入到run中时, 都会执行循环抢票, 但可能会出现两个人抢到同一张票, 还可能会出现有人拿到第-1张票
    - 这就是线程对同一个对象的属性进行了操作导致, 线程不安全。

## 2.Lambda表达式(Demo5)
- Lambda表达式使用的优势
    - 避免匿名内部类定义过多
    - 可以让你的代码看起来更简洁
    - 去掉了没有意义的代码部分

- 函数式接口定义: 
    - 任何接口, 如果只包含有唯一一个抽象方法, 那么它就是一b个函数式子接口。
    - 对于函数式子接口, 我们可以通过lambda表达式类创建该接口的对象。

- Demo5: 推导lambda表达式全过程。第6, 7步可以看出, 只需要专注内部重写方法的实现

## 3.静态代理(Demo6)
- Demo6: 以一个婚礼为例子总结静态代理模式
- 真实对象类 和 代理对象类 都需要实现同一个接口, 代理对象类需要有一个真实对象(需要用构造方法获取一个真实对象)。
- 代理对象可以做很多真实对象做不了的事情, 真实对象专注于自己的事情就可以了。
- 多线程其实利用静态代理来实现的, Thread类其实就是实现了Runnable的代理类

## 4.线程的五大状态(Demo7)
- 创建状态: 当new一个Thead类的时候就是创建状态
- 就绪状态: 对象.start()
- 执行状态: CPU分配资源到就绪状态的线程, 此时线程就会进入执行状态
- 阻塞状态: 当调用sleep, wait, 同步锁定, 则会线程会进入到阻塞状态, 阻塞解除后重新进入就绪状态等待CPU分配资源
- 结束状态: 线程结束或死亡

### 4.1 停止线程
- TestStop.java
- 不推荐使用JDK提供的stop(), destroy()方法
- 建议使用一个标志位 flag, 当flag = false时终止线程。对外提供一个方法来改变这个flag状态

### 4.2 线程休眠(sleep)
- sleep 指定当前线程阻塞的毫秒数(一般在run方发中调用Thread.sleep(200))
- sleep存在异常InterruptedException
- sleep时间达到后线程进入就绪状态
- sleep可以模拟网络延时
- 每一个对象都有一个锁, sleep不会释放锁

### 4.3 线程礼让(yield)
- 让当前执行的线程暂停, 但不阻塞, 也就是让当前的线程从运行状态转为就绪状态
- 让CPU重新调度, 礼让不一定成功.(Thread.yield)

### 4.4 线程插队(Join)
- Join合并线程, 待此线程执行完成之后, 再执行其他线程, 其他线程被阻塞。
- 可以认为是线程插队

### 4.5 查看线程状态(State)
- Thread.state可以查看当前线程的状态
- 状态有: 
    - NEW: 尚未启动的线程处于此状态。 
    - RUNNABLE: 在Java虚拟机中执行的线程处于此状态。
    - BLOCKED: 被阻塞等待监视器锁定的线程处于此状态。
    - WAITING: 正在等待另一个线程执行特定动作的线程处于此状态。
    - TIMED_WAITING: 正在等待另一个线程执行动作达到指定等待时间的线程处于此状态。(阻塞)
    - TERMINATED: 已退出的线程处于此状态。

## 5.线程优先级(Demo8)
- 优先级最小为1, 最大为10, 优先级越高, CPU安排该线程的可能性越大.
- 优先级低只是意味着获得CPU调度的概率低, 并不是不会被调用。
- 使用 对象.setPriority(int), 来进行设置。
- 使用 对象.getPriority(), 获得线程的优先级。

## 6.守护(daemon)线程(Demo9)
- 线程分为用户线程(比如main()线程) 和 守护线程
- 虚拟机必须确保用户线程执行完毕, 不会等待守护线程完成(守护线程会在用户线程执行结束之后就会被停止。)
- 使用 对象.setDaemon(bool true) 来设置为守护线程.

## 7.线程同步(Demo10)
- 并发: 多线程操作同一个资源, 会出现并发问题。
- 当多个线程访问同一个对象, 并且某些线程还想修改这个对象时, 我们就需要线程同步。
- 线程同步其实是一种等待机制, 多个需要同时访问此对象的线程进入这个**对象的等待池**
- 锁: 当一个线程获得对象的排他锁, 独占资源, 其他线程必须等待, 使用后释放锁即可。因此会存在性能问题。
- 通过加入一个synchronized关键字, 使得某个方法变成 同步方法; 或者使用synchronized同步块。
- synchronized方法控制"对象"的访问, 每个对象对应一把锁, 每个synchronized方法都必须获得调用该方法的对象的锁才能执行。
- synchronized方法一旦执行, 就独占该锁, 直到该方法返回才释放锁, 后面被阻塞的线程才能获得这个锁, 继续执行。
- 注意: 方法里需要有修改的内容才需要锁, 否则会浪费资源。
- 注意: synchronized默认锁的对象是this, 如果变化的量不是this对象, 则需要使用synchronized同步块。

### 7.1 死锁(Demo11)
- 多个线程各自占用一些共享资源, 并且互相等待其他线程占有的资源才能运行, 而导致两个或多个线程都在等待对方释放资源, 都停止执行的情形。某一同步块同时拥有两个以上对象的锁时, 就可能发生死锁问题
- 产生死锁的必要条件: 
    - 互斥: 一个资源每次只能被一个进程使用
    - 请求与保持: 一个进程因请求资源而被阻塞时, 对方一获得资源且保持不放。
    - 不剥夺: 进程已获得的资源, 在未使用前不能被强行剥夺
    - 循环等待: 如果进程之间形成一种收尾相接的循环等待资源关系
- 尽量避免一个synchronized块中又有一个synchronized块

### 7.2 显式定义同步锁(Demo12)
- java.util.concurrent.locks.Lock接口是控制多个线程对共享资源进行访问的工具。锁提供了对共享资源的独占访问, 每次只能有一个线程对Lock对象加锁, 线程开始访问共享资源前应先获得Lock对象。
- ReentrantLock类实现了Lock接口, 他拥有与synchronized相同的并发性和内存语义, 在实现线程安全的控制中, 比较常用的是ReentrantLock。
- Lock只能锁代码块

## 8.线程协作
- 生产者消费者模式
- 应用场景: 
    - 假设仓库只能存放一件产品, 生产者将生产除的产品放入仓库, 消费者将仓库中的产品取走
    - 如果仓库中没有产品, 则生产者将产品放入仓库, 否则(仓库中有产品)停止生产, 直到仓库中的产品被消费者取走为止。
    - 如果仓库中有产品, 则消费者将取走仓库中的产品, 否则(仓库中没有产品)停止消费, 并等待, 直到仓库中再次有产品为止。
- 分析:
    - synchronized可以阻止并发更新同一个共享资源, 实现了同步, 但不能实现不同线程之间的通信。
- 线程通信:
    - wait() / wait(long time): 线程一直等待, 直到其他线程通知, 与sleep不同, wait会释放锁
    - notify() / notifyAll() : 唤醒一个处于等待状态的进程 / 唤醒同一个对象上所有调用wait()方法的进程, 优先级高的进程先被调用。
- 解决方式1(Demo13): 生产者负责生产数据的模块, 消费者负责处理数据的模块, 但消费者不能直接使用生产者的数据, 他们之间有一个缓冲区
- 解决方式2(Demo14): 采用一个标志符, 通过标志符来判断当前线程的启动与等待。

## 9.线程池(Demo15)
- 提前创建好多个线程, 放入线程池, 使用时直接获取, 使用完直接放回, 可以避免频繁创建和销毁, 实现重复利用
- 线程管理:
    - corePoolSize: 核心池的大小
    - maximumPoolSize: 最大线程数
    - keepAliveTime: 线程没有任务时最多保持多长时间会终止
- ExecutorService: 线程池对象类型, 我们需要创建一个这个服务。
    - 使用 对象.execute(Runnable接口实现类) 就可以启动线程
    - 注意使用完成后需要关闭线程池子: 对象.shutdown()
    - 创建ExecutorService对象时, 使用Executors.newFixedThreadPool(线程池大小)即可
    








