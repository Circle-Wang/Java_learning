package Demo5;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;

public class TestPaint {
    public static void main(String[] args) {
        new MyPaint().loadFrame("我的画板");
    }
    
}

class MyPaint extends Frame{

    public void loadFrame(String title){
        setBounds(200, 200, 600, 500);
        setVisible(true);

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
        // 更换画笔颜色
        g.setColor(Color.red);
        // 画园
        g.drawOval(100, 100, 20, 10); // 空心椭圆
        // 再更换画笔颜色
        g.setColor(Color.green);
        g.fillOval(120, 100, 20, 20); // 实心园
        
        // 画矩形
        g.fillRect(200, 200, 150, 100); // 实心矩形
    }


}
