# GUI编程

## AWT模块
### 1、窗口生成(Demo1)
- 创建一个Frame对象
- 通过setSize，setLocation，setBackground，setVisible设置窗口的基本属性。
- 这一个窗口无法通过点击关闭，只能通过终止程序来停止。

### 2、面板Panel(Demo1)
- Panel可以看成一个空间，小号的窗口，内部可以放入组件，并且可以自定义面板内部布局模式
- 使用窗口监听器的方式，解决了点击关闭窗口的问题

### 3、布局的三种方式(Demo2)
- 一个窗口的所有组件可以按照三种方式自动布局。分别是：流式布局(从左到右)，东西南北中布局，表格布局
- 东西南北中布局需要在frame.add中使用BorderLayout.EAST去对组件布局进行设定
- 流式布局和表格布局不需要再add中设置，直接使用frame.setLayout(),确定好布局形式后，由程序自动将组件排列。
- 可以对这些布局进行嵌套，使用面板进行嵌套.将内部组件放进面板中，再将面板放入窗口中。在不同面板和窗口中可以使用不同的布局，从而形成了嵌套

### 4、事件监听(Demo3)
- 当某个操作触发时，执行相关的操作，不如键盘监听，点击监听。
- 通过 组件.addActionListener(ActionListener接口类对象) 来实现对组件的监听
- 我们可以让多个组件使用同一个监听类，还可以在监听类中执行判断，用于展示那个按钮被触发了。

### 5、输入框(Demo4)
- 使用TextField构造出一个输入框(单行数据框)，在监听器中使用e.getSource()返回一个对象，这个对象可以强转为TextField类
- 输入框的事件触发是摁下Enter
- 我们还可以使用TextField的多个方法实现隐藏密码输入，回车换行清空等操作。
- 示例练习: 设计一个计算器, 学习新的组件标签Label
    - 使用内部类的方式设置监听器可以直接使用计算器类的属性，更加方便操作
    - 使用frame.pack()可以让排布自适应大小，这样可以不用设置窗口大小了
    - frame.setTitle()可以设置窗口名字

### 6、画笔以及鼠标事件监听(Demo5)
- 重写paint方法来实现自定义画图
    - paint方法会在初始化面板之后立即执行一次
    - g.setColor()更换颜色
    - g.fillxxx()画实心的图案
    - g.drawxxx()画空心的图案
- 对窗口增加鼠标监视器addMouseListener()，实现点击画图功能
- 我们可以采用适配器模式(继承自MouseAdapter)自定义一个自己的鼠标监听器
    - 使用e.getX()和e.getY()可以获得当前事件发生时鼠标所在位置坐标，并传递给画板让其作画。
    - 使用frame.repaint()重新执行paint方法, 刷新画板
    - new Point(x,y)是awt的一个点这个对象
    - 注意: 如果采取本样例中的方式则画板中只会记录一个点，在刷新画板时之前画的点都会消失，因为刷新画paint函数中只会作画一个点。
    - 若想保留下所有的点则需要使用ArrayList来储存所有的Point，而在paint函数中则采用迭代的方式遍历出所有的Point进行作画。

### 7、窗口事件监听(Demo6)
- 和鼠标事件监听一样，使用addWindowListener()增加窗口事件监听
- 我们依然可以通过继承WindowAdapter，并重写其中的windowClosing方法(这个方法是在点击窗口的x时触发的)
- 其实从Demo1的TestPanel.java开始，我们就使用了这种方式，不过那时候采用的时匿名内部类的方式进行的。
- WindowAdapter还有一些常用的方法可以重写，比如windowOpened(打开窗口时触发)，windowActivated(激活窗口时)

### 8、键盘事件监听(Demo7)
- addKeyListener()增加键盘监听，继承KeyAdapter实现键盘监听。本例子中使用匿名内部类的方式进行重写方法
- 键盘中每一个键都有一个数值来指代，可是使用e.getCode()获得这键的int值
- 常见使用方法keyReleased(当键盘被释放时触发), keyPressed(当键盘摁下时触发)


## Swing模块
是基于AWT模块进行了封装，并对一些功能进行了扩展，这是最常用的GUI编程方式
### 1、JFrame的基本操作(Demo8)
- 由于JFrame是对AWT的封装，因此对Frame的操作余AWT基本一致, 对JFrame对象常见的操作是：frame.setBounds(设置大小), frame.setVisible(设置可见)，frame.setDefaultCloseOperation(设置窗关闭事件)
- 一般对于JFrame的操作我们不直接对JFrame对象进行添加组件等操作。我们会使用frame.getContentPane()获得一个Container容器对象，对这个容器对象进行操作，比如改变背景，添加组件/面板，设置布局。
- 窗口背景颜色设置
    - 如果直接使用setBackground()设置的确实是JFrame的颜色，不过在JFrame打开时默认看到的是JFrame.getContentPane()，而JFrame上的contentPane默认是Color.WHITE的，所以，无论你对JFrame或者Frame怎么设置背景颜色，你看到的都只是contentPane.
    - 解决方法一：不直接使用setBackground()，而是使用frame.getContentPane().setBackground(Color.blue);
    - 解决方法二：调用frame.getContentPane()方法得到一个contentPane容器，然后将其设置为不可见，即setVisible(false)
- 窗口监听
    - 更简单的做法不用再去重写WindowAdapter类了，frame.setDefaultCloseOperation(数值)，不同数值表示关闭方式不同，可以使用WindowConstants.xxx直接获取常用值。如果不设置窗口监听，默认是关闭窗口但不结束进程。
- 组件/面板的设置和添加
    - 组件的添加可以直接使用frame.add()的即直接在JFrame里添加，也可以是使用frame.getContentPane().add()这样做就是在JFrame的内容里添加组件(frame.getContentPane()会返回一个Container对象)
    - JLabel(标签组件)
        - JLabel.setHorizontalAlignment(int)可以设置label在容器中的位置，使用SwingConstants.xxx可以获取常见值
    - JButton(按钮组件)
        - button.setBounds可以将按钮组件在绝对位置进行定位.(需要将容器或者JFrame布局设定为绝对布局setLayout(null))
        - 给button绑定点击事件，addActionListener(ActionListener接口类对象)
    - JPanel(面板)
        - 面板的概念与AWT的面板概念相同，多个面板布局组合可以得到很多复杂的布局
    - JScrollPane(带滑动的面板)
        - 当面板的大小小于某个组件的设定值时会会出现"滑动"
    - JTextArea(文本域组件)
        - 可以换行的文本框
- 弹窗设置(Dialog)
    - 点击之后出现一个新的窗口, 需要继承于JDialog接口类。将弹窗当作一个窗口操作即可，默认就有关闭事件就可以不用再写了。
    - 可以认为这个弹窗就是一个窗口，因此也要设置setBounds(设置大小), setVisible(设置可见), 甚至可以放入button
- 图标(Icon)
    - 需要implements Icon接口，并实现其存在的3个方法。
    - 其中最重要的就是事现paintIcon方法，使用画笔画图像。
    - 图标类可以放在标签上，也可以放在按钮上。使用对象.setIcon(Icon类)
    - new ImageIcon(url)可以将外部图片读入变成一个图标, 使用getResource(路径)获取图片的地址url

### 2、其他常用组件介绍(Demo9)
- 单选框(JRadioButton)
    - 可以通过new JRadioButton()得到多个单项选择框。
    - 将这些单选框添加进一个ButtonGroup()中才能实现多个选项只能选1个，注意ButtonGroup并不是组件，所以不用使用add方法添加进窗体中，ButtonGroup只是告诉我们那些单选框是互斥的。
- 多选框(JCheckBox)
    - 可以通过new JCheckBox()得到多个复选框。
    - 不过这就不需要放入一个ButtonGroup()中了(当然想用也可以)
- 下拉框(JComboBox)
    - new JComboBox()可以得到一个下拉框对象
    - 使用 对象.addItem(str)，即可添加出下拉选项的内容
    - 为JComboBox添加监听addActionListener，即可实现对不同选择的反馈。
- 列表框(JList)
    - new JList(集合对象)可以得到一个列表框对象，并且集合对象中的内容会显示在列表框中
    - 可以先添加集合对象，再对集合对象进行添加数据(JList支持动态对象)
- 文本框(JTextField)
    - 只能输出一行的文本框。
- 密码框(JPasswordField)
    - 默认的密码框，使用setEchoChar('*')也可实现输入文字自动转化为\*.
    - 并且输入的内容只能是字符，不能是文字

### 3、实现贪吃蛇小游戏(snake)
- 基本界面(StartGame.java)
    - 为了使得蛇能够按格子移动, 因此需要固定窗口界面大小。
- 绘制基本界面图片
    - 通过继承JPanel，得到一个MyPanel对象，并在这个MyPanel对象上进行作画。需要重写paintComponent方法，该方法会默认调用(不需要手动调用)
    - 将MyPanel对象add到基本界面中即可实现画面的添加。
- 由于贪吃蛇身体，头部，广告位置位置的图片都来自于文件，并且需要使用new ImageIcon(url)，转化为ImageIcon对象
    - ImageIcon对象有一个方法，对象.painIcon()(这个方法我们在Demo8中重写过)，这个方法第一个参数Component表示在哪里画，第二个参数g表示画笔对象，第三，四的参数表示开始画的位置。
    - 我们在Demo8中使用过 组件对象.setIcon(ImageIcon对象/Icon对象)的方式进行调用过，不过此时的painIcon()是隐藏调用了被，本例子中将会是显示调用。
- 静态数据(Data)
    - 为了更好的践行面向对象编程，我们可以将所需要的静态资源(图片)抽象成一个对象，对象中的属性都是ImageIcon对象，Data的作用是将这些ImageIcon对象初始化，以便使用。
- 为了画出各时刻的蛇的状态，我们需要记录下以下两点: 头的状态, 每一节组织的位置坐标, 蛇整体长度
    - 给头分配一个状态，根据状态的不同画不同的图片，使用switch结构
    - 用数组记录下每一节组织的坐标，使用for循环画出。
    - g.setFont(new Font())的方式可以实现字体的设置。
- 对类直接implements KeyListener重写接口类即可。主要要在初始化时setFocusable(true)时屏幕是焦点。
- 使用Timer类实现定时刷新功能 new Timer(100,this) 表示100毫秒执行一次this中的actionPerformed方法。
    - 需要implements ActionListener，实现actionPerformed方法，这个方法中用于更新蛇每一节组织的位置。
    - Timer第二个参数需要传入ActionListener接口类。
- 实现KeyListener接口的keyPressed方法，需要完成以下功能。
    - 上下左右摁键触发时改变头部方向
- 实现ActionListener接口的actionPerformed方法，需要完成以下功能
    - 根据头部方向更新每一节组织的位置坐标
    - 需要做边界处理。
    - 判断食物是否被吃，并更新食物坐标。
    - 失败判定
- 总结：
    - 功能的增加一般分为三个部分：定义数据，画图，监听事件(用于更改数据)
    - 使用Timer，使得隔断时间执行actionPerformed，而actionPerformed主要用于数据的修改，并repaint()
    - repaint()的调用将会执行paintComponent()方法，paintComponent()只根据数据实现单帧画图。
    






