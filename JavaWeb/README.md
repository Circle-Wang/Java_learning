# JavaWeb开发

## 第一章：基本概念
web开发包括有以下组件：
- 静态Web：由html，css组成，提供给网页访问者访问，但不会发生改变
- 动态Web：由Servlet/JSP，ASP，PHP技术栈

Java中动态web资源开发的技术统称为JavaWeb
- a.html、b.html...这些统称为web资源，这些web资源可以被外部进行访问，对外界提供服务。
- 一个web应用由多部分组成（静态Web + 动态Web）


## 第二章：Servlet
- 用于开发动态web技术的一种。
- 提供了一个中JAVA接口Servlet，如果想开发Servlet程序只需要编写一个实现Servlet的接口类，并把其部署到web服务中

### 2.1、使用Servlet类完成前后端的数据交互
- 步骤一：我们需要首先继承HttpServlet这个类（这个类是继承自Servlet的）,在日常项目中我们需要重写doGet、doPost方法
  - doGet方法：当浏览器发送get请求时，程序需要执行的操作逻辑。传入参数就是request和response。这可以根据request读取前端传入的数据，并通过response对象将我们的操作映射到前端去
  - doPost方法：当浏览器发送post请求时，程序需要执行的操作逻辑。传入参数也是request和response。
  - 注意：HttpServlet这个类版本有很多需要根据tomcat版本来定（最好是从tomcat版本中直接提取对应jar包）
- 步骤二：当我们把java类写好之后，我们还需要将这个类映射到前端的页面中（即通过url让用户能进入到Servlet类中）,因此我们需要在web.xml中进行配置**url——类**的映射
  ```xml
  <!-- 将我们创建的Servlet类注册到web中，这里的name可以随意取-->
  <servlet>
        <servlet-name>myServlet</servlet-name>
        <servlet-class>HelloServlet</servlet-class>
  </servlet>

  <!-- 将前面绑定的Servlet名字和url进行对应，这样用户在访问对应url时能进入相应的类中-->
  <servlet-mapping>
      <servlet-name>myServlet</servlet-name>
      <url-pattern>/hello</url-pattern>  <!-- 这里要注意需要加/-->
  </servlet-mapping>
  ```
- 前面提到了在web.xml中我们可以对java类进行映射。实际上我们可以同一个java类采用不同的url进行映射，甚至我们可以使用通配符*对任意的符合条件的url进行跳转
  ```xml
  <servlet-mapping>
    <servlet-name>myServlet</servlet-name>
    <url-pattern>/hello</url-pattern>  <!-- 这里要注意需要加/-->
  </servlet-mapping>
  <servlet-mapping>
    <servlet-name>myServlet</servlet-name>
    <url-pattern>/hello2</url-pattern>  <!-- 这里要注意需要加/-->
  </servlet-mapping>
  <servlet-mapping>
    <servlet-name>myServlet</servlet-name>
    <url-pattern>/hello*</url-pattern>  <!-- 这里要注意需要加/-->
  </servlet-mapping>
  ```

### 2.2、ServletContext对象
- ServletContext对象：
  - 我们可以对HttpServlet对象执行getServletContext()方法从而获得ServletContext对象，这个对象可以作为传输中间件，从而实现多个HttpServlet对象间的信息传输。其本质是每一个web程序只有一个Servlet对象。
  - 相关方法：
    - context.setAttribute(键,值): 将键值对数据储存在HttpServlet对象中，可以由其他的程序读取。
    - context.getAttribute(键): 根据键，将context中储存的数据读取出来，结合setAttribute方法从而实现在不同的HttpServlet对象中传递数据。
    - context.getInitParameter(键): 获得web.xml文件中<context-param>标签下的数据，根据键来获得值
    - context.getRequestDispatcher("/其他url"): 请求转发。可以将当前的请求，转发到另外一个url中，该方法返回一个RequestDispatcher对象，我们调用该对象的forward方法(req, resp)，就可以实现将请求转发。
    - context.getResourceAsStream("/文件相对路径")：读取文件。该方法可以在读取classpath下的文件并返回一个InputStream对象。就可以完成对文件的读取

### 2.3、HttpServletResponse对象
- 前面有有提到,我们重写doGet、doPost方法时需要传入两个对象，其中HttpServletResponse对象就是用于响应客户端使用的。
- 常用方法：
  - 对象.getOutputStream() / 对象.getWriter(): 用于获得输出流，将信息输出到浏览器。(如果需要实现文件下载操作需要设定调用resp.setHeader()方法)
  - 对象.setHeader(): 用于设置响应对象的Header信息。比如页面显示的编码：charset=UTF-8
- 重定向策略：当一个web资源B收到客户端A的请求后，资源B会通知A去访问另一个web资源C，这个过程叫做重定向。这与提到的转发不一样，重定向会导致url发生改变。(并且当前的响应会报出302的状态码)
  - 对象.sendRedirect("/其他url"): 会重定向到其他web资源，并且会改变url跳转。

### 2.4、HttpServletRequest对象
- 与HttpServletResponse对象相对，用户通过HTTP请求协议访问服务器的时候，请求中的所有信息会被封装到Request对象中，我们可以使用Request对象的相关方法获取到前端传输过来的东西。
- 常用方法：
  - 对象.setCharacterEncoding("UTF-8"): 设置获取前端数据的编码格式。获取的数据编码要和前端发送的编码格式要一致。
  - 对象.getParameter(String): 通过组件名来获取参数信息, 返回String。
  - 对象.getParameterValues(String): 如果组件名所对应的数据有多个(比如组件数个多选框，一般会以post请求发送这些数据)，我们用这个方法会返回一个String数组。


## 第三章：Cookie和Session
- Cookie: Cookie其实就是一些数据信息，类型为“小型文本文件”，存储于电脑上的文本文件中。一般情况下，cookie是以键值对进行表示的(key-value)，例如name=jack，这个就表示cookie的名字是name，cookie携带的值是jack。第一次访问服务器时，服务器产生cookie传输给客户端，客户端保存该cookie，在客户端第二次访问服务端时，带上这个cookie，则服务器可以识别该访问
- Session: 用户打开一个浏览器，点击了很多链接，访问多个Web资源，关闭浏览器，这个过程称之为会话。服务器为了保存用户状态而创建的一个特殊的对象。简而言之，session就是一个对象，用于存储信息。

### 3.1、Cookie对象
- 我们可以使用 Request对象.getCookie()，获得一个Cookie对象数组(因为服客户端可能传递多个Cookie对象，但客户端第一次访问时Cookie一定为空), 因此我们需要创建一个Cookie对象(直接使用new Cookie(键,值)即可)，并使用Response.addCookie(Cookie对象)将服务器端生成的Cookie发送客户端去。
  - Request对象.getCookie(): 获得Cookie对象数组
  - Response对象.addCookie(Cookie对象)：向客户端发送Cookie
- Cookie对象相关方法：
  - 对象.getName(): 获得Cookie对象的名字(键)。
  - 对象.getValue(): 得到当前Cookie的值。
- Cookie具有有效期，我们可以通过Cookie.setMaxAge()设置Cookie有效期，默认是-1, 即关闭浏览器就会失效。否则浏览器会储存该键值对在本地文件中。

### 3.2、Session对象(重点)
- session是存储于服务器端的特殊对象，服务器会为每一个浏览器(客户端)创建一个唯一的session。这个session是服务器端共享，每个浏览器(客户端)独享的。我们可以在session存储数据，实现数据共享。
- 我们可以使用req.getSession()获得一个HttpSession对象。
- Session对象常用方法：
  - 对象.setAttribute(键, 值): 在Session中存入数据。
  - 对象.getAttribute(键)：从Session中获取数据
  - 对象.removeAttribute(键): 从Session中删除数据
  - 对象.getId(): 获得Session的ID
  - 对象.invalidate(): 手动注销Session
- 我们也可以在web.xml中配置Session的失效时间：
  ```xml
    <session-config>
    <!--以分钟为单位，自动失效当前session会话-->
    <session-timeout>3</session-timeout>
  </session-config>
  ```


## 第四章：JSP(了解)
- Java Server Pages: java服务端页面，与Servlet一样，用于动态Web技术。
- JSP的编写类似于HTML一样是标签语言。但与HTML不同的是JSP中可以嵌入java代码，因此可以使得页面可以动态变化。
- JSP本质上就是一个Servlet的接口对象。在tomcat服务器会自动生成jsp.class文件, 这个文件就是一个JAVA的class对象
  - 在.jsp文件中使用<%....%>括起来的部分可以输入java代码
  - 在.jsp文件中${..}中可以使用内置对象
  - 在.jsp文件中只要是java代码会被原封不动的输出，如果是HTML代码则会被转化为`out.write("<html>\r\n")`。这些代码都会放在JSP.class对象的_jspService()这个方法当中

### 4.1、JSP基础语法和指令
- JSP基本语法：
  - JSP表达式: `<%= 变量、表达式%>`
  - 针对上面的使用变量的方式，我们还可以使用EL表达式：`${变量名}`的方式使用
  - JSP脚本片段: `<%  java脚本片段   %>`
    - 这部分java脚本会被放在_jspService()方法中被tomcat服务器渲染成前端页面中去
    - 可以将脚本片段和HTML代码进行嵌合，从而实现很多操作
  - JSP声明：`<%! java代码块  %>` 
    - 这部分代码块会被编译在JSP.class类中，注意不是在_jspService()方法中，因此这里面声明的变量可以被类全局应用，作用域更高。
- JSP指令：
  - <%@page 配置%>: 可以实现当前jsp文件的配置，比如导入java包，定制错误页面
  - <%@include 配置%>: 可以将其他jsp文件中的内容与当前jsp的内容合二为一进行联合编码。多个jsp文件中的作用域是通用的，因此可能存在多个jsp文件中同名变量冲突。

### 4.2、JSP中九大内置对象
- 这些内置对象可以被在JSP文件中直接被使用。(被定义在JSP类中的)
  - PageContext: 页面上下文代表整个页面，可以用来共享内容
  - Request: 请求对象, 也可以用来存数据对象
  - Response: 响应对象
  - Session: 会话对象，与前文Servlet中的HttpSession对象一样的。
  - Application(ServletContext类): 用于共享内容
  - config(ServletConfig类):
  - out: 用于输出到前端页面
  - page
  - exception
- PageContext、Request、Session、Application用于数据共享的区别与联系
  - 上述的四个对象都可以使用 `对象.setAttribute(键, 值)`的方式存放对象，并在其他位置使用`对象.gerAttribute(键)`的方式获取数据
  - 作用域区别：
    - PageContext：该对象存放的数据, 只在当前页面有效(当前JSP文件中有效, 也就是当前的JSP对象.class中)
    - Request: 储存在当前请求对象中, 如果发生请求转发, 那么会跟随对象转发出去。
    - Session: 在一次会话中有效(从打开浏览器到关闭浏览器整个过程中都有效)
    - Application: 保存的数据在整个服务器有效，作用域最高，可以被不同的对象访问。
- PageContext实现转发：`pageContext.foward("目标url")`



























### 4.3、JSP标签、JSTL标签、EL表达式
- EL表达式：`${变量名}`, 需要在pom中导入对应的jar包
  - 获取数据
  - 执行运算
  - 获取Web开发的常用对象
- JSP标签：`<jsp:方法 配置>`, 例如下面代码：
  ```xml
  <!-- 这段代码表示进行url转发, 并携带了相关的参数-->
  <jsp:forward page="/url">
    <jsp:parm name="userName" value="CircleWang"/>
    <jsp:parm name="passWord" value="123456"></jsp:parm>
  </jsp:forward>
  ```
- JSTL标签：`<c:if 判断条件> 代码块 </c:if>`
  - JSTL标签库的使用是为了弥补HTML标签的不足，标签的功能和java代码一样。(要使用JSTL标签需要声明头导入响应的标签库，并需要注意项目pom和tomcat也需要导入包)
  - 相关的方法需要自行百度，比较重要的是核心库的标签，比如c:if、c:forEach等

