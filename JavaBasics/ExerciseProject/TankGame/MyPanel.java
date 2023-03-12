package ExerciseProject.TankGame;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.*;
import java.util.Vector;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JPanel;



// 这是游戏主界面类
public class MyPanel extends JPanel implements KeyListener, Runnable{

    Tank heroTank = null;  // 用户坦克
    Vector<EnemyTank> enemyTanks = new Vector<>();  // 敌人坦克
    int enemyTankSize = 3;  // 敌人坦克池
    Vector<Bomb> bombs = new Vector<>();  // 敌人坦克

    // 画炸弹的资源
    Image image1 = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("src/boom1.png"));
    Image image2 = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("src/boom2.png"));
    Image image3 = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("src/boom3.png"));

    // 主面板构造函数 用于敌方坦克和己方坦克初始化
    public MyPanel() {
        heroTank = new Tank(10,10,0);
        heroTank.setSpeed(20);

        for (int i = 0; i < enemyTankSize; i++ ){  // 初始放入3个敌方坦克
            EnemyTank enemyTank = new EnemyTank(100*(i+1), 0);
            enemyTank.setSpeed(20);  // 设置移动速度
            enemyTank.setDirection('D');
            enemyTanks.add(enemyTank);
            new Thread(enemyTank).start(); // 开启敌方坦克线程
        }
    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 900, 700); // 背景

        // 画坦克
        drawTank(heroTank, g);   
        for (EnemyTank enemyTank : enemyTanks) {
            drawTank(enemyTank, g);
        }

        // 画出子弹
        g.setColor(Color.YELLOW);
        for (int i = 0; i < heroTank.shots.size(); i++) {
            Shot shot = heroTank.shots.get(i);
            if (shot.isLive) {  // 只画出存在的子弹
                g.fillOval(shot.X, shot.Y, 3, 3);
            } else {
                heroTank.shots.remove(shot);
            }
        }

        // 画爆炸效果
        for (int i = 0; i < bombs.size(); i++) {
            Bomb bomb = bombs.get(i);
            // 根据当前炸弹生命周期画不同爆炸图片，从而出现切换效果
            if (bomb.life > 4) {
                g.drawImage(image1, bomb.X, bomb.Y, 60,60, null);
            } else if (bomb.life > 2) {
                g.drawImage(image2, bomb.X, bomb.Y, 60,60, null);
            } else {
                g.drawImage(image3, bomb.X, bomb.Y, 60,60, null);
            }
            bomb.lifeDown();
            // 如果当前炸弹生命周期结束则剔除队列
            if (bomb.isLive == false) {
                bombs.remove(bomb);  
            }
        }

        // 判断敌方坦克是否被击中
        hitEnemyTank();

    }


    // 在(x,y)坐标画坦克
    public void drawTank(Tank tank, Graphics g) {
        if (tank.getType() == 1) {
            g.setColor(Color.CYAN);
        } else {  
            g.setColor(Color.YELLOW);  // 用户坦克黄色
        }
        int x, y;
        char dir;
        x = tank.getX(); // 获取坐标
        y = tank.getY();
        dir = tank.getDirection(); // 获取方向
        switch (dir) {
            case 'U':
                g.fill3DRect(x, y, 10, 60, false); // 轮子
                g.fill3DRect(x + 30, y, 10, 60, false); // 轮子
                g.fill3DRect(x + 10, y + 10, 20, 40, false);
                g.fillOval(x + 10, y + 20, 20, 20);
                g.drawLine(x + 20, y + 30, x + 20, y);
                break;
            case 'D':
                g.fill3DRect(x, y, 10, 60, false); // 轮子
                g.fill3DRect(x + 30, y, 10, 60, false); // 轮子
                g.fill3DRect(x + 10, y + 10, 20, 40, false);
                g.fillOval(x + 10, y + 20, 20, 20);
                g.drawLine(x + 20, y + 30, x + 20, y + 60);
                break;
            case 'L':
                g.fill3DRect(x, y, 60, 10, false); // 轮子
                g.fill3DRect(x, y + 30, 60, 10, false); // 轮子
                g.fill3DRect(x + 10, y + 10, 40, 20, false);
                g.fillOval(x + 20, y + 10, 20, 20);
                g.drawLine(x + 30, y + 20, x, y + 20);
                break;
            case 'R':
                g.fill3DRect(x, y, 60, 10, false); // 轮子
                g.fill3DRect(x, y + 30, 60, 10, false); // 轮子
                g.fill3DRect(x + 10, y + 10, 40, 20, false);
                g.fillOval(x + 20, y + 10, 20, 20);
                g.drawLine(x + 30, y + 20, x + 60, y + 20);
                break;
        }
    }


    // 根据方向键改变方向
    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();  // 获取按键
        // 坦克移动
        switch (keyCode) {  // 根据摁键使用
            case KeyEvent.VK_UP:
                heroTank.moveUp();
                break;
            case KeyEvent.VK_DOWN:
                heroTank.moveDown();
                break;
            case KeyEvent.VK_LEFT:
                heroTank.moveLeft();
                break;
            case KeyEvent.VK_RIGHT:
                heroTank.moveRight();
                break;
        }

        // 摁键J 监控子弹发射
        if (keyCode == KeyEvent.VK_J) {
            heroTank.tankFire();
        }
        repaint();  // 重新绘画
    }

    // 判断是否击中敌方坦克，并更新敌方坦克信息
    public void hitEnemyTank() {
        for (int i = 0; i < heroTank.shots.size(); i++) {
            Shot shot = heroTank.shots.get(i);
            if (shot.isLive) { // 如果子弹存在则遍历判断是否击中了敌方坦克
                for (int j = 0; j < enemyTanks.size(); j++) { // 遍历所有敌方坦克
                    EnemyTank enemyTank = enemyTanks.get(j);
                    switch (enemyTank.getDirection()) {
                        case 'L':
                        case 'R':
                            if (shot.X > enemyTank.getX() && shot.X < enemyTank.getX() + 60
                             && shot.Y > enemyTank.getY() && shot.Y < enemyTank.getY() + 40) {
                                shot.isLive = false;
                                enemyTanks.remove(enemyTank);
                                bombs.add(new Bomb(enemyTank.getX(), enemyTank.getY())); // 放入一个炸弹对象进入集合等待被画出
                            }
                            break;
                        case 'U':
                        case 'D':
                            if (shot.X > enemyTank.getX() && shot.X < enemyTank.getX() + 40
                             && shot.Y > enemyTank.getY() && shot.Y < enemyTank.getY() + 60) {
                                shot.isLive = false;
                                enemyTanks.remove(enemyTank);
                                bombs.add(new Bomb(enemyTank.getX(), enemyTank.getY())); // 放入一个炸弹对象进入集合等待被画出
                            }
                            break;
                    }
                }
            }
        }
    }


    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }


    // 让该面板不断重新画
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            this.repaint();
        }
        
        
    }
 
}
