package ExerciseProject.TankGame;


// 敌方坦克对象
public class EnemyTank extends Tank implements Runnable {


    public EnemyTank(int x, int y) {
        super(x, y, 1);  // 坦克类型为1
    }

    // 每个敌人是一个线程，自己移动
    @Override
    public void run() {
        while (this.isLive) {
            int moveSteps = (int)(Math.random() * 6);
            int randDirect =  (int)(Math.random() * 4);
            switch (randDirect) {
                case 0:
                    for (int i = 0; i < moveSteps; i++) {
                        moveUp();
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 1:
                    for (int i = 0; i < moveSteps; i++) {
                        moveDown();
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 2:
                    for (int i = 0; i < moveSteps; i++) {
                        moveLeft();
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 3:
                    for (int i = 0; i < moveSteps; i++) {
                        moveRight();
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
            }
        }

    }

}
