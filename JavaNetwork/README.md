# 网络编程知识

### 1、InetAddress对象和InetSocketAddress对象(Demo1)
- 一台电脑有着IP地址，我们可以通过IP地址来确定目标电脑。
- InetAddress对象无法通过new 对象的方式获取(因为其构造器作用域不是public,包外无法调用)，我们可以调用InetAddress.getByName()方法来返回得到一个InetAddress对象.
- InetAddress常用方法:
    - InetAddress.getByName("域名/IP"): 可以获得一个InetAddress对象。
    - InetAddress.getLocalHost(): 可以获得本机IP地址的InetAddress对象。
    - 对象.getHostAddress(): 获取InetAddress对象的IP地址(String)
    - 对象.getHostName(): 获取InetAddress对象的域名/主机名(Sting)
- 有时我们仅仅只知道目标机器的IP是不够的，因为一台机器中可能存在多个服务，因此我们常需要采用IP+端口的方式锁定目标服务。我们可以使用InetSocketAddress对象来进行
    - 每个端口(0-65535)绑定了一个进程，且端口不能共用，因此一些公有端口(0-1023)不要使用.
    - 分配给程序注册的端口(1024-49151)常见的：8080(Tomcat), 3306(MySQL)
- InetSocketAddress常用方法:
    - new InetSocketAddress("IP", port): new一个InetSocketAddress对象，包含有IP和端口号。
    - 对象.getAddress(): 可以得到一个InetAddress对象。

### 2、Socket编程(Demo2)
- Socket(套接字): 通信的两端都需要有Socket, 是两台机器间通信的端点。网络通信其实就是Socket间的通信。Socket允许程序把网络连接当成一个流，数据在两个Socket间通过IO传输。一般主动发起通信应用的一方属于客户端，等待通信请求的为服务端。 
- Socket常用方法:
    - new Socket(目标IP的InetAddress对象, 端口号): 得到一个Socket连接对象, 该语句会向目标IP:端口 发起连接请求, 如果连接失败抛出ConnectException。
    - socket对象.getOutputStream(): 将数据按照流的方式发送数据(用于发送数据), 得到一个与socket对象关联的OutputStream对象
    - socket对象.getInputStream(): 将数据以流的方式读入(用于接收数据), 得到一个与socket对象关联的InputStream对象
- ServerSocket常用方式:
    - new ServerSocket(端口号): 在本机开放一个端口号, 并对该端口号进行监听。
    - 对象.accept(): 连接请求队列中取出一个客户的连接请求，然后创建与客户连接的Socket对象(并返回)。如果队列中没有请求，则一直等待并阻塞程序。(注意一个ServerSocket可以执行多个.accept()方法，也就得到多个Socket对象)

### 3、TCP实现聊天(Demo2)
- TCP协议: 存在客户端和服务端之分, 两端之间会采用三次握手的方式进行连接后才能稳定进行点对点传输。优点是可靠，缺点是效率低。
- 服务器端：通过创建一个new ServerSocket(端口号)对象, 可得到一个能被连接的地址。
    - serverSocket.accept()可以得到一个 Socket对象。(此处表示已和客户端完成连接)
    - socket.getInputStream()得到InputStream对象
    - 使用IO中的数据流实现数据的读出
    - 别忘记关闭socket和管道流
- 客户端：通过创建一个new Socket(InetAddress对象, 端口号)对象, 即可完成一个连接对象的建立。
    - 可以使用socket.getOutputStream()得到 OutputStream对象，os.write(内容)即可实现数据的发送
    - 别忘记了关闭socket

### 4、TCP实现文件上传(Demo3)
- 服务器端：创建一个new ServerSocket(端口号)对象，得到可连接地址
    - 使用FileOutputStream对象获得得到的最终结果。
    - 增加一个功能是告诉客户端内容接收完毕，可以断开连接。
- 客户端: 通过FileInputStream获得文件输入流, 并将文件传入File()
    - 使用os.write将资源写出
    - 这里需要注意: 当发送结束时，需要执行socket.shutdownOutput(), 这样可以告知对面我这边已经没有发送的东西了，你不需要再等待read了 
    - 获取到服务器端的消息。

### 5、UDP(Demo4)
- UDP协议: 没有服务器端和客户端的区别, 因此不需要建立连接。只需要将数据、目的地、源封装成一个数据包传输即可(类似于广播)。优点是速度快(每个大小数据包限制在64K以内)，缺点是不可靠，因为只负责发送，对方是否能收到不受保证。
- DatagramSocket常用方法:
    - new DatagramSocket(): 得到一个socket对象, 用于数据包的传输。此时socket绑定的是本机的任意空余端口。当然也可以指定绑定到本机的指定端口。
    - 对象.send(DatagramPacket对象): 将DatagramPacket数据包对象发送出去。
    - 对象.receive(DatagramPacket对象): 用于接收DatagramPacket数据包。将收到的数据放入到DatagramPacket对象中。注意该方法会阻塞程序，直到收到为止。
- DatagramPacket常用方法:
    - new DatagramPacket(byte[] 数据, 0, length, InetAddress address, int port): 构造用于发送指定长度(length)的数据报包到 指定主机上的指定端口。(也可以使用InetSocketAddress来替代最后两个参数)
    - 对象.getAddress(): 查看包裹接收/发送数据包的IP地址
    - 对象.getData(): 得到数据byte[]数组


### 6、使用UDP实现多线程聊天(Demo5)
- 使用BufferedReader(new InputStreamReader(System.in)) 可以读取控制台的输入
- 使用多线程需要继承 Runnable类 并重写其run方法
- 要实现两个客户端的对话，需要一个程序执行两个线程，一个线程是一直接收信息(一直执行)，一个线程是一直发送信息(一直执行)，因此我们要针对这两个功能写出TalkSend，和TalkReceive两个单独的模块
- TalkSend
    - 我们构造器中需要实现new DatagramSocket的实例化，BufferedReader(获取控制台的输入)的实例化，并开启连接。
    - 在run方法中 需要使用while(true)循环，一直发送信息给目标用户。
    - 对于TalkSend我们需要知道向谁IP/端口发送。
- TalkReceive
    - 在run方法中接收命令即可, 在构造方法中需要指定监听的端口。

### 7、使用URL下载资源(Demo6)
- URL的构成：协议(http、https) //IP:端口(140.2.1.22:8080) / 项目名 / 资源
- URL这个类是java.net.URL。通过new URL("字符串")得到对象
- 常用方法：
    - 对象.getHost
    - 对象.getPath
    - 对象.getQuery
    - 对象.getFile
    - 对象.getProtocol
- 使用url.openConnection()得到一个HttpURLConnection对象，通过该对象.getInputStream()就可以读取数据流了












