package ExerciseProject.TankGame;

import java.util.Vector;

// 坦克类
public class Tank {
    private int X;  // 坦克坐标(左上角)
    private int Y;
    private int type; // 坦克类型0, 1
    private char direction = 'R';
    private int speed; // 坦克移动速度
    boolean isLive = true;  // 坦克生存状态
    Vector<Shot> shots = new Vector<>(); // 用于存放发射的子弹

    public Tank(int x, int y, int type) {
        X = x;
        Y = y;
        this.type = type;
    }

    // 坦克移动
    public void moveUp() {
        direction = 'U';
        // 控制坦克移动范围不超出边界
        if (Y > 0) {
            Y = Y - speed > 0 ? Y-speed: 0 ;
        }
    }
    public void moveDown() {
        direction = 'D';
        if (Y < 700-60 ) {
            Y = Y + speed < (700-60) ? Y+speed: (700-60) ;
        }
    }
    public void moveLeft() {
        direction = 'L';
        if (X > 0 ) {
            X = X - speed > 0 ? X-speed: 0 ;
        }
    }
    public void moveRight() {
        direction = 'R';
        if (X < 900-60 ) {
            X = X + speed < (900-60) ? X+speed: (900-60) ;
        }
        
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    public int getType() {
        return type;
    }

    public char getDirection() {
        return direction;
    }

    // 设置坦克方向
    public void setDirection(char direction) {
        this.direction = direction;
    }

    // 设置坦克移动速度
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    // 坦克发射子弹
    public void tankFire() {
        // 需要根据当前坦克状态初始化子弹位置
        Shot shot = null;
        switch (direction) {
            case 'U':
                shot = new Shot(X+20, Y, direction);  
                break;
            case 'D':
                shot = new Shot(X+20, Y+60, direction);
                break;
            case 'L':
                shot = new Shot(X, Y+20, direction);
                break;
            case 'R':
                shot = new Shot(X+60, Y+20, direction);
                break;
        }

        // 将发射的子弹放入坦克的子弹列表中
        shots.add(shot);
        // 即启动子弹线程
        new Thread(shot).start();
    }

    
}
