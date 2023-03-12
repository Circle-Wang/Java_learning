package ExerciseProject.TankGame;


import javax.swing.JFrame;

public class StartGame extends JFrame {
    MyPanel mp = null;

    public static void main(String[] args) {
        new StartGame("坦克大战");
        
    }

    public StartGame(String title){
        super(title);
        this.mp = new MyPanel();
        this.add(mp);
        new Thread(mp).start();  // 启动面板，让其每隔一段时间运行repaint


        // 对开始窗口进行基本设置
        this.setBounds(10,10,950,750);
        this.setResizable(false);  // 设置窗口大小不变
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        // 对面板进行监听
        this.addKeyListener(mp);
    }

    
}
