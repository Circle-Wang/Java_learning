# JavaWeb开发

## 第一章：

## 第二章: 

## 第三章：Servlet
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

### 2.2、


















