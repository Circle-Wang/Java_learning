## 1、IO知识
- 基本介绍：输入流，输出流都是针对自己内存而言


### 1.1、文件(Demo1)
- new File(String): 通过路径创建一个文件对象。
    - 方法2：new File(File对象, String)来根据某个File对象以及子路径创建文件
    - 方法3：new File(String, String) 父路径 + 子路径
- 我们可以通过一些File的方法来获取文件的相关信息
    - 对象.getName：获得文件名
    - 对象.getAbsolutePath: 获得绝对路径
    - 对象.length: 获取文件大小(单位字节)，也就是字节长度
    - 对象.getParent: 获得文件父目录
    - 对象.exists: 判断文件是否存在
    - 对象.isFile: 判断是否是一个文件
- 目录操作
    - 对象.mkdir(): 创建一级目录 
    - 对象.mkdirs(): 创建多级目录 
- 文件/目录删除
    - 对象.delete(): 删除空目录或者文件，会返回一个bool值显示是否成功

## 2、IO原理以及分类
- 输入Input：将外部文件(磁盘，网络来的数据)读入程序(内存)，需要使用输入流
- 输出Output: 将程序(内存)的数据输出到外部(网络，磁盘)，需要使用输出流
- 操作单位的不同分为：
    - 字节流(8bit)，常用来操作二进制文件(音乐，视频等无损操作)
    - 字符流(根据编码不同每个字符所占字节不同)，字符流输出效率更高，但主要用于字符
- 按流的角色不同可以分为:
    - 节点流
    - 包装流
- 常见的流的顶级父类
    - 字节流的输入流：InputStream(抽象类，需要使用子类来得到流对象)
    - 字节流的输出流：OutputStream(抽象类)
    - 字符流的输入流：Reader(抽象类)
    - 字符流的输出流：Writer(抽象类)
    - 常见的IO流对象，都是这些父类的子类，结尾都会表明该子类来自那个父类，例如：FileOutputStream, BufferedReader
- 流: 可以看作一个管道/物流人员，文件和程序(内存)可以类比为终端。


### 2.1、FileInputStream, FileOutputStream(Demo2)
- FileInputStream: 文件字节输入流。
    - 有三种构造方式，常见从完整文件路径构造、从File对象构建。
    - 读取方法: 
        - 对象.read(): 从该输入流从外部(磁盘)读取一个字节的数据(int表示), 如果返回-1, 表明读取完毕. (这种方式读取中文(字符)会出现问题,因为该方式每次只读取1个字节,而一个中文字符在UTF-8下是三个字节).由于文件不可能只有一个字节,因此使用循环进行读取.
        - 对象.read(byte[] b): 从该输入流从外部(磁盘)读取b.length个字节的数据到b中, 如果返回-1, 表明读取完毕. 第一个字节在b[0], 第二个字节在b[1]....如果读取正常, 返回实际读取的字节数.(如果文件中字节数不够b.length, 则返回读取到的字节长度). 我们可以通过new String类来将byte[]数组读取为一个字符串.

- FileOutputStream: 文件字节输出流
    - 若不存在对应文件会自动创建文件，也会默认覆盖。若不想覆盖则需要在创建FileOutputStream对象时, 增加一个传参
    - 对象.write(int): 可以将一个int的数字转化为二进制写出文件中
    - 对象.write(byte[]): 可以将字节数组写出到文件

- 文件拷贝功能的实现FileCopy.java
    - 需要同时创建 输出流和输入流 对象
    - 注意一般是在while循环中每一次就写出一次

### 2.2、FileReader, FileWriter(Demo3)
-  FileReader：文件字符输入流
    - 有三种构造方式，常见从完整文件路径构造、从File对象构建。
    - 读取方式
        - 对象.read(): 每次读取单个字符，可以读取一个汉字了。如果到文件末尾返回-1
        - 对象.read(char[]): 批量读取多个字符到字符数组中,每次返回读取到的字符长度, 如果返回-1, 表明读取完毕.
-  FileWriter：文件字符输出流
    - 若不存在对应文件会自动创建文件，默认覆盖原始文件内容。若不想覆盖则需要在对象时, 增加true的传参。
    - 对象.write(char[]): 将字符数组全部内容写入
    - 对象.write(String): 将字符串写入
    - 注意，只有使用 对象.close，或者 对象.flush，才会完成文件的写入。

### 2.3、节点流和处理(包装)流区别
- 节点流：可以从一个特定的数据源读写数据，前面讲到的针对文件对象的FileInputStream，FileWriter...都是节点流。比如针对的数组对象的ByteArrayInputStream，CharArrayWriter...。一般节点流都是比较底层的功能，直接对文件进行了操作。
- 包装流：一般包装流的类中都会封装一个节点流对象，该节点流对象可以是任意的顶级父类的子类，因此包装流不会局限一个数据源。例如BufferedReader可以封装任意的Reader的子类，BufferedWriter可以封装任意的Writer的子类....。包装流可以很好的消除不同节点流对数据源的限制，也提供了更方便的方法来完成输入输出。


### 2.4、BufferedReader、BufferedWriter(Demo4)
- 针对字符的包装流，写入和写出分别是BufferedReader和BufferedWriter
- BufferedReader: 字符的输入包装流
    - 生成包装流BufferedReader对象时，需要放入一个FileReader对象
    - 对象.readLine(): 按行读取(\n或者\t为换行标识)，会返回个一个字符串。如果读取到最后则返回null。 一采用循环会循环。注意此处读入内存是换行符没有被读入。
- BufferedWriter: 字符的输出包装流
    - 生成包装流BufferedWriter对象时，需要放入一个FileWriter对象
    - 对象.write(String): 直接写入字符串
    - 对象.newLine(): 插入一个符合系统相关的换行符
    - 文件写入采用覆盖/追加的方式，我们应该在FileWriter对象定义时设定。
- 使用BufferedReader和BufferedWriter，进行文件的拷贝。注意写入文件时注意每一行需要换行。
- 关闭流时只用关闭外层流(BufferedReader或者BufferedWriter对象)即可。注意不要去操作二进制文件，因为BufferedReader和BufferedWriter是针对字符处理的。






- BufferedInputStream: 带缓冲的字节输入流，其直接父类是FilterInputStream
- ObjectInputStream: 对象字节输入流。









