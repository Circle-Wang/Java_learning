package Demo9;


// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.*;
import java.awt.*;

public class TestJFrame extends JFrame{

    public void init(){
        // 窗口基本设置
        setBounds(100,100,500,500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Container container = getContentPane();
        container.setLayout(new GridLayout(3,2,10,10)); // 设置布局

        // 单选框
        JRadioButton jRadioButton1 = new JRadioButton("选项1");
        JRadioButton jRadioButton2 = new JRadioButton("选项2");
        JRadioButton jRadioButton3 = new JRadioButton("选项3");
        ButtonGroup buttonGroup = new ButtonGroup();  // 将所有单选框放进一个分组中，实现多个选项只能选择一个
        buttonGroup.add(jRadioButton1);
        buttonGroup.add(jRadioButton2);
        buttonGroup.add(jRadioButton3);
        container.add(jRadioButton1);
        container.add(jRadioButton2);
        container.add(jRadioButton3);
        
        // 多选框
        JCheckBox jCheckBox1 = new JCheckBox("多项选择1");
        JCheckBox jCheckBox2 = new JCheckBox("多项选择2");
        container.add(jCheckBox1);
        container.add(jCheckBox2);

        // 下拉框
        JComboBox<String> jComboBox = new JComboBox<String>();  // 使用泛型<>保证添加的元素是str,也可以不加<>则可以加入各种各样数据类型。
        jComboBox.addItem(null);
        jComboBox.addItem("下拉选项1");
        jComboBox.addItem("下拉选项2");
        jComboBox.addItem("3");
        container.add(jComboBox);
        
        // 静态列表框
        String[] words = {"1","2","3"};
        JList<String> jList1 = new JList<String>(words);
        container.add(jList1);

        // 动态列表框
        Vector contents = new Vector(); // 此处没有使用范式，因此不会做安全性检查，想放什么就放什么
        JList jList2 = new JList(contents);
        container.add(jList2);
        contents.add("张三");
        contents.add("王五");
        contents.add(2);

        // 密码框
        JPasswordField jPasswordField = new JPasswordField();
        jPasswordField.setEchoChar('*');
        container.add(jPasswordField);

        // 单行文本框
        JTextField JTextField = new JTextField();
        container.add(JTextField);

        setVisible(true);
    }

    public static void main(String[] args) {
        new TestJFrame().init();
    }

}
