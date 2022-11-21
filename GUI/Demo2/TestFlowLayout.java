package Demo2;

import java.awt.*;

public class TestFlowLayout {
    public static void main(String[] args) {
        Frame frame = new Frame();

        // 组件-按钮
        Button button1 = new Button("button1");
        Button button2 = new Button("button2");
        Button button3 = new Button("button3");

        // 设置流式布局,0表示靠左，1表示居中，2表示靠右
        // 从左至右摆满组件，再摆第二层
        frame.setLayout(new FlowLayout(2));

        frame.setSize(200,200);
        frame.add(button1);
        frame.add(button2);
        frame.add(button3);

        frame.setVisible(true);

    }
    
}
