# IO知识
介绍文件数据在程序与硬盘间的交互。输入流，输出流都是针对自己内存而言

### 1、文件(Demo1)
- 创建文件的方法:
    - 方法1：new File(String): 通过路径创建一个文件对象。
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

### 2、IO原理以及分类
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


### 3、文件字节输入输出流(FileInputStream, FileOutputStream)(Demo2)
- FileInputStream: 文件字节输入流。
    - 有三种构造方式，常见从完整文件路径构造、从File对象构建。
    - 读取方法: 
        - 对象.read(): 从该输入流从外部(磁盘)读取一个字节的数据(int表示), 如果返回-1, 表明读取完毕. (这种方式读取中文(字符)会出现问题,因为该方式每次只读取1个字节,而一个中文字符在UTF-8下是三个字节).由于文件不可能只有一个字节,因此使用循环进行读取.
        - 对象.read(byte[] b): 从该输入流从外部(磁盘)读取b.length个字节的数据到b中, 如果返回-1, 表明读取完毕. 第一个字节在b[0], 第二个字节在b[1]....如果读取正常, 返回实际读取的字节数.(如果文件中字节数不够b.length, 则返回读取到的字节长度). 我们可以通过new String类来将byte[]数组读取为一个字符串.
    - 注意: 如果使用FileInputStream来读取字符文件，那么字符本身是什么编码，就会读取成什么编码的字节数据，例如我们读取的文件采用的GBK编码，那读取出的字节码也是GBK编码的，因此在输出时需要采用GBK来解码，即new String(byte[],"GBK").
- FileOutputStream: 文件字节输出流
    - 若不存在对应文件会自动创建文件，也会默认覆盖。若不想覆盖则需要在创建FileOutputStream对象时, 增加一个传参
    - 对象.write(int): 可以将一个int的数字转化为二进制写出文件中
    - 对象.write(byte[]): 可以将字节数组写出到文件

- 文件拷贝功能的实现FileCopy.java
    - 需要同时创建 输出流和输入流 对象
    - 注意一般是在while循环中每一次就写出一次

### 4、文件字符输入输出流(FileReader, FileWriter)(Demo3)
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

### 5、节点流和处理(包装)流区别
- 节点流：可以从一个特定的数据源读写数据，前面讲到的针对文件对象的FileInputStream，FileWriter...都是节点流。比如针对的数组对象的ByteArrayInputStream，CharArrayWriter...。一般节点流都是比较底层的功能，直接对文件进行了操作。
- 包装流：一般包装流的类中都会封装一个节点流对象，该节点流对象可以是任意的顶级父类的子类，因此包装流不会局限一个数据源。例如BufferedReader可以封装任意的Reader的子类，BufferedWriter可以封装任意的Writer的子类....。包装流可以很好的消除不同节点流对数据源的限制，也提供了更方便的方法来完成输入输出。


### 6、字符包装流(BufferedReader、BufferedWriter)(Demo4)
- 针对字符的包装流，写入和写出分别是BufferedReader和BufferedWriter
- BufferedReader: 字符的输入包装流
    - 生成包装流BufferedReader对象时，需要放入一个FileReader对象
    - 对象.readLine(): 按行读取(\n或者\t为换行标识)，会返回个一个字符串。如果读取到最后则返回null。 一采用循环会循环。注意此处读入内存是换行符没有被读入。
- BufferedWriter: 字符的输出包装流
    - 生成包装流BufferedWriter对象时，需要放入一个FileWriter对象
    - 对象.write(String): 直接写入字符串
    - 对象.newLine(): 插入一个符合系统相关的换行符
    - 文件写入采用覆盖/追加的方式，我们应该在FileWriter对象定义时设定。
    - 完成写入之后需要使用.flush()将文件刷新
- 使用BufferedReader和BufferedWriter，进行文件的拷贝。注意写入文件时注意每一行需要换行。
- 关闭流时只用关闭外层流(BufferedReader或者BufferedWriter对象)即可。注意不要去操作二进制文件，因为BufferedReader和BufferedWriter是针对字符处理的。

### 7、字节包装流(BufferedInputStream、BufferedOutputStream)(Demo5)
- BufferedInputStream: 字节的输入包装流
    - 生成包装流BufferedInputStream对象时，需要放入一个InputStream的实现子类对象。
    - 读取与FileInputStream的操作一致，
- BufferedOutputStream: 字节的输出包装流
    - 生成包装流BufferedOutputStream对象时，需要放入一个OutputStream的实现子类对象。
- 使用字节的包装输入流，完成二进制文件的拷贝


### 8、序列化保存(ObjectInputStream、ObjectOutputStream)(Demo6)
- 在实际操作中对一些数据类型需要进行本地化保存，例如需要保存int 100。一些我们自定义的数据对象需要保存到本地(或恢复到内存)则也需要使用Object的输入输出流。上述操作称为基本数据类型/对象的 序列化 和 反序列化。
- 只有实现Serializable接口(标记接口，没有需要实现的方法)的类，才能将该类的对象进行序列化或反序列化。(其实实现Externalizable接口也可以，但该接口需要实现两个方法)。
- ObjectInputStream: 对象的输入包装流 (实现反序列化)
    - 生成包装流ObjectInputStream对象时，需要放入一个InputStream的实现子类对象。
    - 反序列化时需要按照序列化的先后顺序进行
    - 对象.readInt()、对象.readBoolean()、对象.readChar()
    - 对象.readObject(), 返回的是一个Object对象。并且此时会根据文件中自定义类的包路径找到对应的类(如果找不到则会报错)，不过此时该类是以Object存在的(也就是只能使用Object类的相关方法)
    - 注意：如果想要使用序列化前的对象的特有方法，我们必须要在该java程序中可以引用到这个class(序列化时自定义class的包路径会被记录到文件中，我们导入自定义类时class时需要使用到这个同一个路径，否则会被认为不是同一个类【尽管都一样】)，并向下转型(将Object对象转化为对应对象)
- ObjectOutputStream: 对象的输出包装流 (实现序列化)
    - 生成包装流ObjectOutputStream对象时，需要放入一个OutputStream的实现子类对象。
    - 生成的文件后缀可以是任意的。用记事本查看内容可以发现，生成的序列化文件中保存了自定义类的包路径。
    - 对象.writeInt(int)、对象.writeBoolean(bool)、对象.writeChar('a')....这些方法会将数据进行装箱
    - 对象.writeUTF(String): 将String序列化
    - 对象.writeObject(需要序列化的对象)
- 注意事项:
    - 读写顺序要一致。
    - 序列化的类中建议添加一个属性 SerialVersionUID, 如果该属性是一样的，就算是将已经写入文件的类进行修改了，程序也不会认为他们是不一样的类而在反序列化时报错。
    - 序列化对象时，该类的static或transient修饰的属性不会被序列化(可以认为静态变量属于类而不是对象，因此无需序列化)
    - 序列化时，要求对象里的所有属性也必须是能够被序列化的。(例如你的类里有一个属性是Master类，但这个类没有实现Serializable接口，不会被序列会)
    - 序列化是可以继承的，如果父类是可序列化的，那么其所有子类都是可以实现序列化的。

### 9、系统默认输入输出(System.in、System.out)(Demo7)
- 标准输入(默认设备键盘)，标准输出(默认设备显示器)
- System.in: 用于获取键盘的输入(控制台的输入)，运行类型是BufferedInputStream
- System.out: 代表的是标准的输出显示器(控制台的显示)
- 传统方法中System.out.println("xxxx")，就是调用的System.out中的一个打印方法，显示在控制台中。
- 传统方法Scanner(System.in), 就是在获取控制台的键盘键入的输入内容。

### 10、字节转化为字符(InputStreamReader、OutputStreamWriter)(Demo7)
- 转换流：将字节流转化为字符流(处理文件读取乱码的问题)。这两个类都是继承自Reader(字符流)
- 问题: 在使用BufferedReader读取字符文件时，默认读取的字符文件是以UTF-8编码的，因此在解码时也是采用UTF-8方式解码。如果当我们读取的文件不是采用UTF-8编码，此时我们读取出的文件就会出现乱码。为解决这个问题，我们就需要将字节流转化为字符流。
- InputStreamReader: 
    - 构造方法一：InputStreamReader(InputStream对象, 编码格式)，将一个字节流对象，并指定某种编码格式(告知这个文件是什么编码的)进行处理从而变为字符流。
    - 先将FileInputStream包装为InputStreamReader，并指定编码格式(将以什么编码格式来组织二进制字节流)，此时就会获得一个InputStreamReader对象(Reader子类对象)。
    - 将上一步得到的InputStreamReader对象, 传入给BufferedReader获得一个BufferedReader对象。(当然也可以不用再包装成BufferedReader对象，直接采用.read(buffer)读取即可)
- OutputStreamWriter：
    - 构造方法一：OutputStreamWriter(OutputStream对象, 编码格式)，将字节流对象包装成一个字符流。
    - 将FileOutputStream包装为OutputStreamWriter，并指定编码格式，则会之后保存的文件将会是你指定的编码格式。
    - OutputStreamWriter对象.writer(...)

### 11、打印输出流(PrintStream、PrintWriter)(Demo8)
- 打印流：只有输出流，没有输入流。可以将内容输出到文件 或者 控制台(System.out)
- PrintStream: FilterOutputStream的直接子类，因此它为一个字节流
    - System.out其实就是PrintStream对象。
    - PrintStream对象.print(...)会将内容打印到控制台(默认情况下是标准输出)。.print()的底层就是调用的.write()方法
    - 我们可以修改打印的位置的，只需要使用System.setOut(new PrintStream("路径"))，修改之后我们再使用System.out.print(...)将会输出到"路径"，而不是控制台了.从而可以实现将输出打印到文件中
    - PrintStream的构造中可以放入一个OutputStream从而实现对打印内容写入文件。
- PrintWriter: Writer的直接子类，因此它为一个字符流
    - 构造器可以传入OutputStream子类或者Writer子类，文件名

### 12、Properties读取配置文件(Demo9)
- 我们可以通过这个类更加便捷的 读取/修改 配置文件
- 如果要使用Properties读取配置文件，需要对配置文件的书写有要求：
    - 键=值 形式书写
    - 键和值默认为String类型，因此不要有空格和引号
- 常用方法：
    - 对象.load: 加载配置文件
    - 对象.getProperty(key): 根据键获取值
    - 对象.setProperty(key,value): 设置键值对(修改和添加)，注意此时只是在内存中修改了，如果需要保存成文件还需要执行.store
    - 对象.list(PrintStream/PrintWriter对象): 将键值对打印到指定位置
    - 对象.store(OutputStream/Writer, 注释): 将Properties对象储存成文件
    - 对象.get(key): 得到的是一个Object对象。(我们可以+""变成String类型)
- 注意：如果配置文件中存在中文，在保存时会存为unicode码



