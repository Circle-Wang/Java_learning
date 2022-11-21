package Demo4;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import java.awt.event.WindowAdapter;


// 启动类
public class TestCalculator {
    public static void main(String[] args) {
        new MyCalculator().load();
    }
    
}

// 计算器类
class MyCalculator extends Frame{
    
    public TextField name1, name2, name3;

    public void load() {
        // 设置组件
        name1 = new TextField(10); // 文本框长度
        name2 = new TextField(10);
        name3 = new TextField(20);
        Button button1 = new Button("=");
        Label label = new Label("+",1); // 1表示居中

        // 窗口设置
        setTitle("我的计算器");
        setLayout(new FlowLayout(0));  // 设置为流式布局
        add(name1);
        add(label);
        add(name2);
        add(button1);
        add(name3);
        setVisible(true);
        pack(); // 自适应组件大小

        // 设置监听
        button1.addActionListener(new CalculatorMonitor());

        // 监听窗口关闭按钮
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
    }



    // 监听器内部类
    private class CalculatorMonitor implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            int n1 = Integer.parseInt(name1.getText());
            int n2 = Integer.parseInt(name2.getText());
            name1.setText("");  // 将字符清空
            name2.setText("");
            name3.setText(""+ (n1+n2));
        }
    };

}

