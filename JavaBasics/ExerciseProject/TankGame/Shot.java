package ExerciseProject.TankGame;



// 子弹类
public class Shot implements Runnable {
    int X;
    int Y;
    char direct;
    int speed = 20;          // 子弹速度
    boolean isLive = true;  // 子弹存续状态

    // 传入子弹发射时位置，以及运动方向
    public Shot(int x, int y, char direct) {
        X = x;
        Y = y;
        this.direct = direct;
    }

    @Override
    public void run() {
        while (isLive) {

            try {
                Thread.sleep(100);  // 子弹每0.1s移动一次
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            switch (direct) {
                case 'U':
                    Y -= speed; 
                    break;
                case 'D':
                    Y += speed;
                    break;
                case 'L':
                    X -= speed;
                    break;
                case 'R':
                    X += speed;
                    break;
            }

            // 如果超出版面范围
            if (! (X>=0 && Y>=0 && X<=900 && Y<=700)) {
                isLive = false;
                System.out.println("子弹停止");
            }
        } 
    }
    
}
