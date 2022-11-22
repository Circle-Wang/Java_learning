package Demo6;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;

public class TestWindowListener {
    public static void main(String[] args) {
        new WindowFrame();
    }
}

/**
 * InnerTestWindowListener
 */
class WindowFrame extends Frame {

    public WindowFrame() {
        setBackground(Color.BLUE);
        setBounds(100,100,400,400);
        setVisible(true);

        // // 采用匿名内部类的方式, 关闭方法
        // this.addWindowListener(
        //     new WindowAdapter(){
        //         @Override
        //         public void windowClosing(WindowEvent e) {
        //             System.out.println("采用内匿名内部类方法");
        //             System.exit(0); // 结束程序
        //         }
        //     }
        // );

        this.addWindowListener(new MyWindowListener());
    }



    // 采用内部类的方式
    class MyWindowListener extends WindowAdapter{
        // 重写点击关闭按钮时触发
        @Override
        public void windowClosing(WindowEvent e) {
            System.out.println("你点击了X");
            setVisible(false);   // 将数据框隐藏
            System.exit(0); // 结束程序
        }

        // 窗口打开时触发的方法
        @Override
        public void windowOpened(WindowEvent e) {
            System.out.println("窗口首次打开");
        }


    }

}
