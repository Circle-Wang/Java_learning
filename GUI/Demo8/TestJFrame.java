package Demo8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class TestJFrame {

    // init初始化
    public void init() {
        // 窗口基本设置
        JFrame frame = new JFrame("这是我的JFrame");
        frame.setBounds(100,100,500,500);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // 窗口关闭事件

        // 获得JFrame的内容容器
        Container container = frame.getContentPane();
        container.setLayout(new GridLayout(3,2,10,10)); // 设置布局
        container.setBackground(Color.RED);  // 设置背景颜色


        // label组件设置
        JLabel label = new JLabel("欢迎来到JFrame窗口");
        label.setHorizontalAlignment(SwingConstants.CENTER); // 设置label的在容器中的位置模式
        container.add(label);

        // button组件设置
        JButton button1 = new JButton("按键1");
        JButton button2 = new JButton("按键2");
        JButton button3 = new JButton("按键3");
        button1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(e.getActionCommand() + "被点击");
            }
        });  // 采用匿名内部类为button1添加事件监听
        container.add(button1);
        container.add(button2);
        container.add(button3);
        
        // JPanel面板添加
        JPanel panel = new JPanel(new GridLayout(1,2,10,0));
        panel.setBackground(Color.BLUE);
        panel.add(new JButton("按键4"));
        panel.add(new JButton("按键5"));
        container.add(panel);

        // JScrollPane滑动面板和文本域添加
        JTextArea jArea = new JTextArea(10,20); // 显示10行以内则出现上下滑轮，横向显示20字符以内则出现左右滑轮
        JScrollPane scrollPanel = new JScrollPane(jArea);
        container.add(scrollPanel);
        
        // 需要注意把窗口可见放在最后
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new TestJFrame().init();
    }
    
}
