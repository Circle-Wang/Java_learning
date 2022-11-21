package Demo4;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;


public class TestText {
    public static void main(String[] args) {
        new MyFrame();
    }
}

class MyFrame extends Frame {
    // 构造方法
    public MyFrame(){
        // 输入框组件
        TextField textField= new TextField();
        // 将输入框加入到窗口中
        add(textField);   // 此处由于该类继承了Frame所以可以直接使用Frame的一些方法

        MyMonitor myMonitor = new MyMonitor();
        textField.addActionListener(myMonitor);

        // 将输出的文字替换为其他字符显示在窗口中(应用于输入密码时)
        textField.setEchoChar('*');

        // 窗口的其他设置
        setBounds(300,300,500,500);
        setBackground(new Color(40,161,35));
        setVisible(true);


        // 监听窗口关闭按钮
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });

    }
}


// 创建一个事件监听类
class MyMonitor implements ActionListener{

    // 当文本框中输入了回车时, 会激发触发事件
    @Override
    public void actionPerformed(ActionEvent e) {
        TextField field = (TextField) e.getSource();
        // 输出文本框文字
        System.out.println(field.getText());
        // 并且将文字清零
        field.setText(null);
        
    }

}
