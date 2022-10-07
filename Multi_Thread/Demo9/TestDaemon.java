package Demo9;

// 测试守护线程
public class TestDaemon {
    public static void main(String[] args) {
        God god = new God();
        You you = new You();

        Thread godThread = new Thread(god);
        godThread.setDaemon(true);  // 设置该线程为守护线程，默认为false
        godThread.start();   // 守护线程启动

        Thread youThread = new Thread(you);
        youThread.start();   // 用户线程启动
    }
}


class God implements Runnable{
    @Override
    public void run() {
        while (true) {
            System.out.println("上帝守护着你");
        }
    }
}

class You implements Runnable{
    @Override
    public void run() {
        for (int index = 0; index < 365; index++) {
            System.out.println("生活每一天");
        }
        System.out.println("===离开了这个世界===");
    }
}