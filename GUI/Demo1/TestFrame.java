package Demo1;

import java.awt.*;


public class TestFrame {
    public static void main(String[] args) {

        // Frame对象,生成一个窗口,并传入标题名称
        Frame frame = new Frame("第一个java图形窗口");

        // 设置窗口大小
        frame.setSize(400,400);

        // 设置窗口弹出的初始位置(左上角为0,0点)
        frame.setLocation(100, 100);

        // frame.setBounds(x, y, width, height)可以同时设置窗口大小和位置

        // 设置窗口背景颜色,需要传入一个Color对象, 可以使用静态变量Color.Black
        frame.setBackground(new Color(85,150,58));  

        // 设置可见性(如果不设置则窗口不会弹出)
        frame.setVisible(true);

        // 设置固定窗口大小(禁止拖拽拉缩窗口)
        frame.setResizable(false);


    }
    
}