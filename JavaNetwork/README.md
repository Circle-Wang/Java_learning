# 网络编程知识

### 1、InetAddress对象(Demo1)
- InetAddress对象无法通过new 对象的方式获取(因为其无构造函数)，我们可以调用InetAddress.方法来返回得到一个InetAddress对象
- InetAddress.getByName("域名/IP"): 可以获得一个InetAddress对象。
- InetAddress.getLocalHost(): 可以获得本机IP地址的InetAddress对象。

### 2、InetSocketAddress端口(Demo1)
- 每个端口(0-65535)绑定了一个进程，且端口不能共用，因此一些公有端口(0-1023)不要使用.
- 分配给程序注册的端口(1024-49151)常见的：8080(Tomcat), 3306(MySQL)
- 使用new InetSocketAddress("IP", port)得到InetSocketAddress对象。
- 使用 对象.getAddress() 可以得到一个InetAddress对象。

### 3、TCP实现聊天(Demo2)
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
    - 增加一个功能是告诉客户端内容接收完毕，可以断开连接（这里需要注意read结束时需要客户端那边执行socket.shutdownOutput）
- 客户端: 通过FileInputStream获得文件输入流, 并将文件传入File()
    - 使用os.write将资源写出
    - 获取到服务器端的消息。

### 5、UDP(Demo4)
- UDP不需要连接服务器，而是使用"发包"的方式.
    - 使用new DatagramSocket()建立来连接，最终使用 对象.send(packet)方法发送即可。其中packet为一个DatagramPacket对象
    - 我们仍需要建立一个IP地址对象 InetAddress对象，知道发送给谁
    - 使用new DatagramPacket创建一个数据包对象，所需要的参数是：数据字节，字节起始位置，字节终止位置，InetAddress对象，端口
- UDP没有服务器端和客户端的区别，只要完成包的发送就不会报错(无论对方接收不接收)
- 接收信息的代码：
    - 我们依然需要使用new DatagramSocket(端口号)，来开启一个包的接收监听服务
    - 使用new DatagramPacket创建一个接收数据包对象，所需要的参数是：buffer(字节空数组)，起始位置，终止位置。
    - 最终使用 DatagramSocket对象.receive(packet)  (此处会阻塞程序，直到接收到包裹)
    - 获得数据后，packet.getData()可以得到一个字节对象

### 6、使用UDP实现多线程聊天(Demo5)
- 使用BufferedReader(new InputStreamReader(System.in)) 可以读取控制台的输入
- 使用多线程需要继承 Runnable类 并重写其run方法
- 要实现两个客户端的对话，需要一个程序执行两个线程，一个线程是一直接收信息(一直执行)，一个线程是一直发送信息(一直执行)，因此我们要针对这两个功能写出TalkSend，和TalkReceive两个单独的模块
- TalkSend
    - 我们构造器中需要实现new DatagramSocket的实例化，BufferedReader(获取控制台的输入)的实例化，并开启连接。
    - 在run方法中 需要使用while(true)循环，一直发送信息给目标用户。
    - 对于TalkSend我们需要知道向谁IP/端口发送。
- TalkReceive
    - 在run方法中接收命令即可










