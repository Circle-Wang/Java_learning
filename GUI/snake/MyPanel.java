package snake;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;

public class MyPanel extends JPanel implements KeyListener, ActionListener{

    // 设置状态量
    int snakeLength;
    int[] snakeX = new int[600];  // 每一节身体的x坐标
    int[] snakeY = new int[600];  // 每一节身体的y坐标
    int[] food_index = new int[2]; // 食物坐标
    int score;

    boolean stopState = false;  // 游戏暂停状态
    boolean gameState = true;  // 游戏状态,true表示正常进行

    String hearDir;       // 头的方向
    Timer timer = new Timer(100, this);  // ms为单位，定时启动定时器，
    Random random = new Random();  // 随机数



    // 使用构造器实现初始化
    public MyPanel() {
        init();
        addKeyListener(this);  // 加入键盘监听
        setFocusable(true);  // 必须要加这个,才能保证摁键监听有效
        timer.start();  // 定时器启动
    }

    public void init() {
        snakeLength = 3; 
        score = 0;
        hearDir = "R"; // 头的方向也要重置
        snakeX[0] = 100; snakeY[0] = 100;
        snakeX[1] = 75; snakeY[1] = 100;
        snakeX[2] = 50; snakeY[2] = 100; 
        
        food_index[0] = 25 + 25 * random.nextInt(34); // 不包含34
        food_index[1] = 75 + 25 * random.nextInt(22);
    }

    // 主要承担画图的功能
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.WHITE); // 设置背景

        Data.header.paintIcon(this, g, 25, 10); // 头部广告栏画上去
        g.fillRect(25, 75, 850, 550);// 画出下半部分运动矩形。默认游戏静态界面

        // 根据食物坐标画食物
        Data.food.paintIcon(this, g, food_index[0], food_index[1]);

        // 根据不同头部方向画不同的蛇头
        switch (hearDir) {
            case "R":
                Data.right.paintIcon(this, g, snakeX[0], snakeY[0]);
                break;
            case "L":
                Data.left.paintIcon(this, g, snakeX[0], snakeY[0]);
                break;
            case "U":
                Data.up.paintIcon(this, g, snakeX[0], snakeY[0]);
                break;
            case "D":
                Data.down.paintIcon(this, g, snakeX[0], snakeY[0]);
                break;
        }

        // 根据身体数组长度画身体
        for (int i = 1; i < snakeLength; i++) {
            Data.body.paintIcon(this, g, snakeX[i], snakeY[i]);
        }

        // 画计分表
        g.setColor(Color.BLACK);
        g.setFont(new Font("微软雅黑",Font.PLAIN,15)); // 设置字体的方法
        g.drawString("长度:"+snakeLength, 750, 35);
        g.drawString("分数:"+score, 750, 55);


        // 游戏暂停状态
        if (!stopState){
            g.setColor(Color.WHITE);
            g.setFont(new Font("微软雅黑", Font.BOLD,40)); // 设置字体的方法
            g.drawString("摁空格开始游戏", 300, 300);

        }

        // 游戏终止状态
        if (!gameState){
            g.setColor(Color.RED);
            g.setFont(new Font("微软雅黑", Font.BOLD,40)); // 设置字体的方法
            g.drawString("游戏结束, 摁下空格重新开始", 200, 300);
        }



    }

    // 事件监听
    @Override
    public void actionPerformed(ActionEvent e) {
        if (stopState && gameState){  // 如果游戏没有结束，并且没有暂停意味着可以继续更新

            // 更新食物
            if (snakeX[0]==food_index[0] && snakeY[0]==food_index[1]){
                snakeLength ++;
                score += 10;
                // 更新食物位置
                food_index[0] = 25 + 25 * random.nextInt(34); 
                food_index[1] = 75 + 25 * random.nextInt(22);
            }

            // 身体的移动
            for(int i = snakeLength-1; i > 0; i--) {
                snakeX[i] = snakeX[i-1];  
                snakeY[i] = snakeY[i-1];
            }

            // 头部移动根据hearDir的来确定
            switch (hearDir) {
                case "R":
                    snakeX[0] = (snakeX[0]+25 > 850) ? 25 : (snakeX[0]+25);  // 边界判断
                    break;
                case "L":
                    snakeX[0] = (snakeX[0]-25 < 25) ? 850 : (snakeX[0]-25);  // 边界判断
                    break;
                case "U":
                    snakeY[0] = (snakeY[0]-25 < 75) ? 600 : (snakeY[0]-25);  // 边界判断
                    break;
                case "D":
                    snakeY[0] = (snakeY[0]+25 > 600) ? 75 : (snakeY[0]+25);  // 边界判断
                    break;
            }
            
            // 失败判定(头部坐标与身体坐标一致的话)
            for (int i = 1; i < snakeLength; i++) {
                if (snakeX[0]==snakeX[i] && snakeY[0]==snakeY[i]){
                    gameState = false;
                }
            }

            repaint();
        }
    }



    // 键盘事件, 摁下空格转化游戏状态，上下左右变换头部
    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();  // 获取按键

        if (keyCode == KeyEvent.VK_SPACE){
            if (!gameState){ // 如果当前游戏是失败了，应当重新开始
                init();
                gameState = true;
            } else {       
                stopState = !stopState;
            }
            repaint();  // 此处不能省略若现在不进行画图，actionPerformed中永远不会进行更新
        }

        // 通过键盘转换头部方向
        switch (keyCode) {
            case KeyEvent.VK_UP:
                hearDir = "U";
                break;
            case KeyEvent.VK_DOWN:
                hearDir = "D";
                break;
            case KeyEvent.VK_LEFT:
                hearDir = "L";
                break;
            case KeyEvent.VK_RIGHT:
                hearDir = "R";
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }
    
}
