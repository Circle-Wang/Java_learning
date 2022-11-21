package Demo1;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;

public class TestPanel {
    public static void main(String[] args) {
        Frame frame = new Frame();
        // 生成一个面板
        Panel panel = new Panel();

        // 需要将窗口的面板布局清空，默认为面板置顶于窗口中。
        frame.setLayout(null);

        // 设置窗口基本内容
        frame.setBounds(300,300,500,500);
        frame.setBackground(new Color(40,161,35));

        // 给面板设置相对于窗口的坐标,此时窗口的左上角为0,0
        panel.setBounds(50, 50, 400, 400);
        panel.setBackground(new Color(193,15,60));

        // 将面板panel加入到窗口中
        frame.add(panel);

        // 将窗口变为可见
        frame.setVisible(true);

        // 给窗口设置监听，让其能点击关闭
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e){
                // 当点击x时，结束程序运行
                System.exit(0);
            }
        });


    }
    
}
