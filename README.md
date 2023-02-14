# Java_learning
Java学习记录

- [基础语法](https://github.com/Circle-Wang/Java_learning/tree/main/%E5%9F%BA%E7%A1%80%E8%AF%AD%E6%B3%95)
    - 第一章节: 基本数据类型以及变量介绍 (Chapter1)
    - 第二章节: 运算符介绍以及二进制计算细节 (Chapter2)
    - 第三章节: 控制结构 (Chapter3)
    - 第四章节: 数组、排序、查找 (Chapter4)
    - 第五章节: 类、对象、方法 (Chapter5)
    - 第六章节: 面向对象编程 (Chapter6)
    - 第七章节: 面向对象编程(高级) (Chapter7)
    - 第八章节: 枚举和注解(Chapter8)
    - 第九章节: 异常详解(Chapter9)
    - 第十章节: 常用类(Chapter10)
    - 第十一章节: 集合(Chapter11)
    - 第十二章节: 泛型(Chapter12)

- [Multi_Thread](https://github.com/Circle-Wang/Java_learning/tree/main/Multi_Thread): 多线程学习
    - 第一章: 进程与线程(Chapter1)
    - 第二章: Thread基本知识(Chapter2)
    - 第三章: 线程安全(Chapter3)

- [GUI](https://github.com/Circle-Wang/Java_learning/tree/main/GUI): 图形界面学习
    - AWT模块
        - Demo1：窗口生成，面板Panel组件，
        - Demo2：组件布局的三种方式
        - Demo3：组件事件监听
        - Demo4：输入框组件介绍，以及输入框监听
        - Demo5：画笔以及鼠标事件监听，可实现自定义画图
        - Demo6：窗口事件监听
        - Demo7：键盘的事件监听
    - Swing模块
        - Demo8：针对Swing模块介绍前文的所有内容，包括组件，弹窗设置，图标设置等新功能
        - Demo9：介绍Swing的其他常用组件
    - snake：实现了贪吃蛇游戏的开发。

- [JavaNetwork](https://github.com/Circle-Wang/Java_learning/tree/main/JavaNetwork): java网络开发
    - Demo1: 介绍InetAddress对象、InetSocketAddress对象。一个包含端口，一个不包含端口。对可以表示一个IP地址
    - Demo2: 介绍TCP编程，ServerSocket对象来启动一个服务器IP，Socket对象是最主要的输入输出对象。实验TCP实现单项传输字符串功能
    - Demo3: 进一步使用TCP完成文件传输功能
    - Demo4: 介绍UDP，介绍DatagramSocket对象、DatagramPacket对象，实现UDP发送信息功能
    - Demo5: 使用UDP和多线程工具，实现相互聊天功能
    - Demo6: 简单介绍URL对象，实现网络数据下载功能

- [JavaIO](https://github.com/Circle-Wang/Java_learning/tree/main/JavaIO): java中IO流学习
    - Demo1: 了解File类的相关方法，创建文件夹/文件，删除文件和文件目录
    - Demo2: FileInputStream, FileOutputStream 字节输入和输出流的介绍以及使用
    - Demo3: FileReader, FileWriter 字符输入和输出流的介绍以及使用
    - Demo4: BufferedReader、BufferedWriter 这两者是包装流，需要通过传入Reader或者Writer类来构建，主要用于更高效的字符文件读写效率。
    - Demo5: BufferedInputStream、BufferedOutputStream 需要通过传入InputStream或者OutputStream类来构建，主要用于更高效的字节文件读写。
    - Demo6: ObjectInputStream、ObjectOutputStream 将对象实现序列化(Output)和反序列化(Input)
    - Demo7: 先介绍了System.in、System.out标准输入和标准输出这两者，并进一步介绍了InputStreamReader、OutputStreamWriter这两个转化类可以将InputStream或者OutputStream转化为Reader和Writer，处理乱码的情况。
    - Demo8: PrintStream、PrintWriter打印流的介绍，可以将数据打印到指定文件或者默认控制台。(只有输出)
    - Demo9: 介绍使用Properties类来更方便的读写配置文件
