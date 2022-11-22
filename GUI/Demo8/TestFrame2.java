package Demo8;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.*;
import java.awt.*;

public class TestFrame2 extends JFrame {

    public void init(){
        // 窗口基本设置
        setBounds(100,100,500,500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Container container = getContentPane();
        container.setLayout(new GridLayout(3,2,10,10)); // 设置布局

        // 为按钮增加弹窗
        JButton button1 = new JButton("按键1");
        button1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                new MyDialog(); // 弹出弹窗
            }
        });  // 增加监听事件
        container.add(button1);

        // 为文本增加图标
        JLabel label1 = new JLabel("这是一个画笔图标",SwingConstants.CENTER);
        JLabel label2 = new JLabel("这是一个网络图片图标",SwingConstants.CENTER);
        label1.setIcon(new MyIcon(16,16));
    
        URL url = TestFrame2.class.getResource("图标.png");
        Image image = new ImageIcon(url).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT); // 将图片转换下大小
        label2.setIcon(new ImageIcon(image));

        container.add(label1);
        container.add(label2);

        setVisible(true);
    }

    public static void main(String[] args) {
        new TestFrame2().init();
    }

}

// 弹窗类
class MyDialog extends JDialog {

    public MyDialog() {
        // 弹窗基本设置
        setBounds(500,500,400,200);
        setTitle("弹窗");

        // 组件设置
        JButton button = new JButton("确定");
        JLabel label = new JLabel("这是一个弹窗");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        button.setBounds(150,100,100,50);
        add(button);
        add(label);

        setVisible(true);
    }

}

// 图标类
class MyIcon implements Icon{

    private int width;
    private int height;
    
    public MyIcon(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        // 使用画笔g画一个圆圈
        g.setColor(Color.red);
        g.drawOval(x-width/2, y-height/2, width, height); // 空心椭圆

    }

    @Override
    public int getIconWidth() {
        return width;
    }

    @Override
    public int getIconHeight() {
        return height;
    }

}
