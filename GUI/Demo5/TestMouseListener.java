package Demo5;

import java.awt.*;

import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;

public class TestMouseListener {
    public static void main(String[] args) {
        new MyFrame("点击画图");
    }
    
}

// 窗口类
class MyFrame extends Frame{

    Point point; // 记录点对象

    public MyFrame(String title) {
        // 窗口基础设置
        super(title); // 使用父类Frame的初始化, 将名字传进去, 也可以使用setTitle()方式定义
        setBounds(200, 200, 400, 300);
        setVisible(true);

        // 添加鼠标事件监视器
        this.addMouseListener(new MyMouseListener());

        // 监听窗口关闭按钮
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });

    }

    // 重写paint方法
    @Override
    public void paint(Graphics g) {
        if (point != null){
            g.setColor(Color.red);
            g.fillOval(point.x, point.y, 10, 10); // 在point的位置画一个点
        }
    }

    // 事件监听内部类
    class MyMouseListener extends MouseAdapter{
        // 鼠标监听有多种方式，比如摁下时触发，松开时触发，摁下并松开时触发，鼠标进入组件时触发...

        // 当鼠标摁下时触发
        @Override
        public void mousePressed(MouseEvent e) {
            // MyFrame frame = (MyFrame) e.getSource(); // 获取到当前操作的对象
            point = new Point(e.getX(), e.getY()); // 将鼠标当前位置坐标传递给point
            
            // frame.repaint(); // 刷新画板
            repaint();
        }
    }
    
}


