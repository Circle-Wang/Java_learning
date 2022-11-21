package Demo3;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;

public class TestActionEvent {
    public static void main(String[] args) {
        Frame frame = new Frame();
        // 设置窗口基本内容
        frame.setBounds(300,300,500,500);
        frame.setBackground(new Color(40,161,35));
        frame.setVisible(true);

        Button button1 = new Button("btn1");
        // 给组件添加监听
        button1.addActionListener(new MyActionListener());

        // 将组件放入窗口中
        frame.add(button1, BorderLayout.CENTER);

        // 该方法会监控frame的关闭键是否被点击
        windowClose(frame);

    }

    // 关闭窗口的方法
    private static void windowClose(Frame frame){
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });

    }

}


// 创建一个事件监听类
class MyActionListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
        // 点击时执行的逻辑
        System.out.println("被点击了");
        
    }

}
