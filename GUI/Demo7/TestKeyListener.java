package Demo7;


import java.awt.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;

public class TestKeyListener {
    public static void main(String[] args) {
        new MyFrame();
    }
}


class MyFrame extends Frame{

    public MyFrame() {
        setBounds(200, 200, 400, 300);
        setVisible(true);


        // 匿名内部类实现键盘监听
        addKeyListener(new KeyAdapter(){

            // 当键盘被摁下时触发
            @Override
            public void keyPressed(KeyEvent e) {
                int keycode = e.getKeyCode();
                System.out.println("你摁下的键的数值是:" + keycode);
                if (keycode == KeyEvent.VK_B){
                    System.out.println("你摁下了B");
                }
            }
        });


        // 匿名内部类实现窗口监听
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });

    }

    
    
}
