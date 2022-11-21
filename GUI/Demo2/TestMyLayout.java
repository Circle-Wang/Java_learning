package Demo2;

import java.awt.*;
public class TestMyLayout {
    public static void main(String[] args) {
        // 创建一个新的窗口
        Frame frame = new Frame();
        frame.setSize(400,400);
        frame.setBackground(Color.BLACK);
        frame.setVisible(true);

        // 生成四个面板，并定义好面板中组件的布局(也可以使用panel2.setLayout()来布局)
        Panel panel1 = new Panel(new BorderLayout());

        Panel panel2 = new Panel();
        panel2.setLayout(new GridLayout(2,1));

        Panel panel3 = new Panel(new GridLayout(1,3));
        Panel panel4 = new Panel(new GridLayout(2,2));

        // 组件-按钮
        Button button1 = new Button("btn1-EAST");
        Button button2 = new Button("btn2");
        Button button3 = new Button("btn3");
        Button button4 = new Button("btn4-WEST");
        Button button5 = new Button("btn5");
        Button button6 = new Button("btn6");
        Button button7 = new Button("btn7");
        Button button8 = new Button("btn8");
        Button button9 = new Button("btn9");
        Button button10 = new Button("btn10");


        // 表格布局,2行1列
        frame.setLayout(new GridLayout(2,1));
        
        // 将组件放入面板2和面板4中
        panel2.add(button2);
        panel2.add(button3);

        panel4.add(button6);
        panel4.add(button7);
        panel4.add(button8);
        panel4.add(button9);


        // 将组件填入面板1和面板3中
        panel1.add(button1, BorderLayout.EAST);
        panel1.add(button4, BorderLayout.WEST);
        panel1.add(panel2, BorderLayout.CENTER); // 这里将面板2放入面板1的中间

        panel3.add(button5);
        panel3.add(panel4);  // 这里将面板4放入面板3的第二个位置
        panel3.add(button10);

        // 将面板1和面板3放入窗口中
        frame.add(panel1);
        frame.add(panel3);

    }
    
}
