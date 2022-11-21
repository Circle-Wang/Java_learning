package Demo3;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;

public class TestActionEvent2 {
    public static void main(String[] args) {
        Frame frame = new Frame();
        // 设置窗口基本内容
        frame.setBounds(300,300,500,500);
        frame.setBackground(new Color(40,161,35));
        frame.setVisible(true);
        frame.setLayout(new FlowLayout(2));

        Button button1 = new Button("btn1");
        Button button2 = new Button("btn2");

        // 可以使用.setActionCommand自定义组件触发的信息，如果不设定则为默认值
        button1.setActionCommand("按钮1的信息");
        button2.setActionCommand("按钮2的信息");

        // 定义一个监听器
        MyMonitor myMonitor= new MyMonitor(); 

        // 多个按钮共享一个监听器
        button1.addActionListener(myMonitor);
        button2.addActionListener(myMonitor);

        frame.add(button1);
        frame.add(button2);

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
class MyMonitor implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {

        System.out.println(e.getActionCommand());

        // 点击时通过e.getActionCommand()获得点击信息
        if (e.getActionCommand() == "btn1") {
            System.out.println("按钮1被点击了"+"信息为："+e.getActionCommand());
        } else if (e.getActionCommand() == "btn2") {
            System.out.println("按钮2被点击了"+"信息为："+e.getActionCommand());
        }
     
    }

}
