package Demo2;

import java.awt.*;

public class TestBorderLayout {
    public static void main(String[] args) {
        Frame frame = new Frame();

        // 组件-按钮
        Button button1 = new Button("East");
        Button button2 = new Button("West");
        Button button3 = new Button("South");
        Button button4 = new Button("North");
        Button button5 = new Button("Center");

        // 东南西北中布局
        frame.setSize(400,400);

        frame.add(button1, BorderLayout.EAST);
        frame.add(button2, BorderLayout.WEST);
        frame.add(button3, BorderLayout.SOUTH);
        frame.add(button4, BorderLayout.NORTH);
        frame.add(button5, BorderLayout.CENTER);

        frame.setVisible(true);

    }
    
}
