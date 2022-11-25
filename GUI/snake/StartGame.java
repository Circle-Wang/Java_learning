package snake;


import javax.swing.*;
import java.awt.*;

public class StartGame extends JFrame {

    public void init() {

        Container container = getContentPane();
        container.add(new MyPanel());
        
        // add(new MyPanel());
        setBounds(10,10,900,700);
        setResizable(false);  // 设置窗口大小不变
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

    }

    public static void main(String[] args) {
        new StartGame().init();
        
    }
    
}
