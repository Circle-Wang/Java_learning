package Demo2;

import java.awt.*;

public class TestGridLayout {
    public static void main(String[] args) {
        Frame frame = new Frame();

        // 组件-按钮
        Button button1 = new Button("btn1");
        Button button2 = new Button("btn2");
        Button button3 = new Button("btn3");
        Button button4 = new Button("btn4");
        Button button5 = new Button("btn5");

        frame.setSize(400,400);

        // 表格布局,3行2列
        frame.setLayout(new GridLayout(3,2));
        
        frame.add(button1);
        frame.add(button2);
        frame.add(button3);
        frame.add(button4);
        frame.add(button5);

        frame.setVisible(true);

    }
}
